package com.gameon.head;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.gameon.hitboxers.Hitboxer;
import com.gameon.hitboxers.Player;

public class Game extends Applet implements Runnable {
private Thread thread = null;
public static final int BREDD = 1320;
private Image bild;
private Graphics2D g;
private Player player;

//GameClock
private Engine engine;
private long lastTime  = System.nanoTime();
private long timer = System.currentTimeMillis();
private final double ns = 1000000000.0 / 60.0; //A billion
private double tickDelta = 0;
private int frames = 0;
private int ticks = 0;

	public void init()
	{
		bild = createImage(BREDD,BREDD);
		g =(Graphics2D) bild.getGraphics();
		Image temp = new ImageIcon("spaceship.png").getImage();
		player = new Player(temp);
		//Makes the game only update 60 times a second
				
	}
	
	
	public void paintComponent(Graphics page)
	{
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, BREDD, BREDD);
		player.draw(g);
		page.drawImage(bild, 0, 0, this);
		
		
	}
	
	
	public void update(Graphics page)
	{
		long now = System.nanoTime();
		tickDelta+= (now-lastTime) / ns;
		lastTime = now;
		if(tickDelta >= 1){
			//	engine.tick();
			ticks++;
			tickDelta--;
		}
		paintComponent(page);
		frames++;
		// outputs the ticks and fps to the title
		if(System.currentTimeMillis() - timer > 1000){
			//Add frame and tick showing
			timer+=1000;
			ticks = 0;
			frames = 0;
			
		}
		
		Graphics2D g= (Graphics2D) (page);
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(thread != null)
		{
			repaint();
			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException error)
			{
				
			}
		}
	}

		/*class MusHanterare extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				BackGround.handleMouse(e);
			}
		}
		
		class TangentLyssnare extends KeyAdapter
		{
			public void keyReleased(KeyEvent e)
			{
				BackGround.bromsa();
			}
			public void keyPressed(KeyEvent e)
			{
				handle(e);
			}
			public void keyTyped(KeyEvent e)
			{
				handle(e);
			}
			public void handle(KeyEvent e)
			{
				int key = e.getKeyCode();
				BackGround.starta();
				switch(key)
				{
				case 39:
					BackGround.right();
				break;
				case 37:
					BackGround.left();
					break;
				
				case 40:
				BackGround.backa();
				break;
				}
			}
		}
	
	*/
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