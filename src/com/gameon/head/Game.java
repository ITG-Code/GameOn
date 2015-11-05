package com.gameon.head;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.gameon.hitboxers.Enemy;
public class Game extends Applet implements Runnable {
private Thread thread = null;
public static final int WIDTH = 1280;
public static final int HEIGHT = 720;
private Image image;
private Graphics2D g;



private static String OS = System.getProperty("os.name").toLowerCase();
private ResourceLoader rl;


//GameClock
private int frames = 0;
private int ticks = 0;
private int aliveTime = 0;
private long timer= 0;

private Engine engine;
protected int[] inputs;





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
		addKeyListener(new KeyBoardInput());
		image = createImage(WIDTH, HEIGHT);
		g =(Graphics2D) image.getGraphics();
		engine = new Engine(rl);
		//player = new Player(temp);
	}
	
	
	public void paint(Graphics page)
	{
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//player.draw(g);
		g.drawImage(rl.getBackground(),0,0,null);
		String pressedKeys = "";
		//System.out.println(inputs);
		g.drawString(pressedKeys, 200, 200);
		engine.getPlayer().draw(g);
		engine.getSuperNova().draw(g);
		Enemy[] e = engine.getEnemies();
		if(e != null){
			for(int i = 0; i < e.length;i++){
				e[i].draw(g);
			}
		}
		if(engine.shot != null){
			engine.shot.draw(g);
		}
		
		
		
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
				
				engine.tick();

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

	class KeyBoardInput extends KeyAdapter{
		private int[] keys;
		private long[] keyTime;
		public void getKeys(){
			inputs = this.keys;
		}
		@Override
		public void keyPressed(KeyEvent e) {
			int key = (int) e.getKeyChar();
			addKey(key);
			e.consume();
		}
		@Override
		public void keyReleased(KeyEvent e) {
		//	System.out.println(keys.length);
			int key = (int) e.getKeyChar();
		   // System.out.println(key);
			removeKey(key);
			e.consume();
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			e.consume();
			
		}
		private void addKey(int key){
			if(key == 65 || key == 97){// A
			//	p.moveLeft();
				engine.p.moveLeft();
			}
			if(key == 68 || key == 100){// D
			//	p.moveRight();
				engine.p.moveRight();
			}
			if(key== 83 || key == 115){ //S
			//	p.userDecelarate();
			}
			if(key== 87 || key == 119){ // W
				engine.getPlayer().accelarate();
			}
			if(key== 66 || key == 98){ // B
				engine.greenShot();
			}
			if(key== 78 || key == 110){ // N
				engine.redShot();
			}
			if(key == 77 || key == 109){ // M
				engine.blueShot();
			}
			
			
			////////////////////////
			if(keys == null){
				keys = new int[1];
				keys[0] = key;
				keyTime = new long[1];
				keyTime[0] = System.nanoTime();
			}
			else{
				boolean exists = false;
				for(int i = 0; i < keys.length;i++){
					if(keys[i] == key){
						exists = true;
					}
				}
				if(!exists){
					//long[] tempTime = new long[keys.length+1];
					int[] tempKeys = new int[keys.length+1];
					for(int i = 0; i < keys.length;i++){
						tempKeys[i] = keys[i];
						//tempTime[i] = keyTime[i];
					}
					//tempTime[tempKeys.length-1] = System.nanoTime();
					tempKeys[tempKeys.length-1] = key;
					
					keys = tempKeys;
					//keyTime = tempTime;
				}
				
			}
			
		
		}
		private void removeKey(int key){
			/*int[] tempKeys = new int[keys.length-1];
			long[] tempTime = new long[keys.length-1];
			for(int i = 0; i < keys.length; i++){
				//If the the key matches the key in the array and 1 game tick in time has passed, remove the key
				if(key == keys[i] && System.nanoTime() >= keyTime[i] + 1000000000.0 / 60.0){
					int keyFoundOffset = 0;
					for(int j = 0; j < keys.length;j++){
						if(i != j){
							tempKeys[i-keyFoundOffset] = keys[i];
							tempTime[i-keyFoundOffset] = keyTime[i];
						}
						else{
							keyFoundOffset = 1;
						}
					}
				}
			}
			keyTime = tempTime;
			keys = tempKeys;*/
			int[] tempKeys = new int[keys.length-1];
			int offset = 0;
			for(int i = 0; i < keys.length;i++){
				if(key == keys[i]){
					offset = 1;
				}
				else{
					tempKeys[i-offset] = keys[i];
					
				}
			}
			keys = tempKeys;
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