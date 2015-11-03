package com.gameon.head;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.gameon.graphics.Render;

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public static int WIDTH = 1280;
	public static int HEIGHT = WIDTH / 16 * 9;
	public static int SCALE = 3;
	public static boolean resizable = false;
	public String title = "GameOn";
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	private ResourceLoader rl;
	private Render render;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
	//conversion of an image to an int array
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(size);
		rl = new ResourceLoader();
		render = new Render(WIDTH, HEIGHT);
		frame = new JFrame();
		
	}
	/**
	 * 
	 */

	
	public synchronized void start(){
		this.running = true;
		this.thread = new Thread(this);
		this.thread.start();
		
	}
	public synchronized void stop(){
		this.running  = false;
		try{
			thread.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@Override
	//The gameloop which runs as long as the game is on.
	public void run() {
		//Makes the game only update 60 times a second
		long lastTime  = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; //A billion
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		while(running){
			long now = System.nanoTime();
			delta+= (now-lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			// outputs the ticks and fps to the title
			if(System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				frame.setTitle("ticks: " + ticks + " fps: " + frames + " - " + this.title);
				ticks = 0;
				frames = 0;
				
			}
		}
		this.stop();
	}
	
	public void tick(){
		
	}
	public void render(){
		//Creates a buffer for show ready frames
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		render.clear();
		render.rend();

		for(int i = 0; i < this.pixels.length;i++){
			this.pixels[i] = render.pixels[i];
		}
		
		
		//creates the context 
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		//g.setColor(Color.RED);
		//g.fillRect(400, 500, getWidth(), getHeight());
		g.drawImage(rl.getBackground(), 0, 0, getWidth(), getHeight(), null);
		g.drawImage(image, 0,0, this.getWidth(), this.getHeight(), null);
		//System.out.println("test");
		
		//Frees up the graphics from RAM
		g.dispose();
		bs.show();
		
	}
	
	
	//Creates the basic window and starts the game
	public static void main(String[] args){
		Game g = new Game();
		g.frame.setResizable(resizable);
		g.frame.setTitle(g.title);
		g.frame.add(g);
		g.frame.pack();
		g.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.frame.setLocationRelativeTo(null);
		g.frame.setVisible(true);
		
		g.start();
	}
	
}
