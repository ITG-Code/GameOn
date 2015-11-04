package com.gameon.head;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.gameon.hitboxers.Player;

public class Game extends Applet implements Runnable {
private Thread thread = null;
public static final int WIDTH = 1280;
public static final int HEIGHT = 720;
private Image image;
private Graphics2D g;
private Player player;



private static String OS = System.getProperty("os.name").toLowerCase();
private ResourceLoader rl;

private int frames = 0;
private int ticks = 0;
private int aliveTime = 0;
private long timer= 0;
//GameClock
private Engine engine;

	public void init()
	{
		System.out.println(OS);
		if(OS.indexOf("win") >= 0){
			rl = new ResourceLoader("\\");
		}
		else if(OS.indexOf("linux") >= 0){
			rl = new ResourceLoader("/");
		}
		else if(OS.indexOf("Mac") >= 0){
			rl = new ResourceLoader("Mac");
		}
		image = createImage(WIDTH, HEIGHT);
		g =(Graphics2D) image.getGraphics();
		
		//player = new Player(temp);
	}
	
	
	public void paint(Graphics page)
	{
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//player.draw(g);
		g.setColor(Color.RED);
		g.fillRect(600,600, WIDTH, HEIGHT);
		//Image temp = new ImageIcon("/wallpaper.png").getImage();
		//System.out.println(temp.getWidth(this));
		//g.drawImage(temp, 0,0, this);
		g.drawImage(rl.getBackground(),0,0,null);
		g.drawString("Ticks: " + this.ticks  + " FPS: " + this.frames, 10, 10);
		g.drawString("Time alive: " + aliveTime + " seconds", 1100, 10);
		page.drawImage(image, 0, 0, this);
		
		
	}
	
	
	public void update(Graphics page)
	{
		paint(page);

		
		//Graphics2D g= (Graphics2D) (page);
		
	}
	
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		long now = 0;
		timer = System.currentTimeMillis();
		long lastTime  = System.nanoTime();
		final double ns = 1000000000.0 / 60.0; //A billion
		double tickDelta = 0;
		while(thread != null){
			now = System.nanoTime();
			tickDelta+= (now - lastTime);
			lastTime = now;
			while(tickDelta >= ns){
				//engine.tick();
				
				ticks++;
				tickDelta-= ns;
			}
			repaint();
			frames++;
			// outputs the ticks and fps to the title
			if(System.currentTimeMillis() - timer > 1000){
				//Add frame and tick showing
				aliveTime = (int) (System.currentTimeMillis() - startTime) / 1000;
				timer+=1000;
				ticks = 0;
				frames = 0;
				
			}
			
		}
	}
	public void start()
	{
		if(thread == null)
		{
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public void stop()
	{
		thread = null;
	}

}