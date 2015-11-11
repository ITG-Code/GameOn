package com.gameon.head;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import com.gameon.input.KeyBoardInput;

public class Game extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread thread = null;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	private Image image;
	private Graphics2D g;
	private static String OS = System.getProperty("os.name").toLowerCase();

	// GameClock variables
	private int frames = 0;
	private int ticks = 0;
	private int aliveTime = 0;
	private long timer = 0;
	private Engine engine;
	private KeyBoardInput input;

	public void init() {
		input = new KeyBoardInput();
		addKeyListener(input);
		image = createImage(WIDTH, HEIGHT);
		g = (Graphics2D) image.getGraphics();
		System.out.println(OS);

		engine = new Engine(OS);
		// player = new Player(temp);
	}

	public void paint(Graphics page) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// player.draw(g);
		g.drawImage(engine.getBackground(), 0, 0, null);
		g.drawImage(engine.getLines(), 0, 0, null);
		g.setColor(Color.GREEN);
		String pressedKeys = "";
		// System.out.println(inputs);
		g.drawString(pressedKeys, 200, 200);
		engine.getPlayer().draw(g);
		engine.getSuperNova().draw(g);

		for (int i = 0; i < engine.getEnemies().size(); i++) {
			engine.getEnemies().get(i).draw(g);
		}

		if (engine.getShots() != null) {
			for (int i = 0; i < engine.getShots().size(); i++) {
				engine.getShots().get(i).draw(g);
			}
		}
		/////////// Debug perpouse
		g.drawString("Player lane: " + Integer.toString(engine.getPlayer().getLane()), 10, 500);
		///////////
		g.drawString("Ticks: " + this.ticks + " FPS: " + this.frames, 10, 10);
		g.drawString("Time alive: " + aliveTime + " seconds", 1100, 10);
		page.drawImage(image, 0, 0, this);

	}
	public void losePaint(Graphics page){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.GREEN);
		g.drawImage(engine.getGameOver(), 200, 250, null);
		g.drawString("Score: " + engine.getScore(), 300, 350);
		
		page.drawImage(image, 0, 0, this);
	}
	public void update(Graphics page) {
		if(engine.gameover == true){
			losePaint(page);
		}
		else{
			paint(page);
		}
		
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		long now = 0;
		timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0; // A billion
		double tickDelta = 0;

		while (thread != null) {
			now = System.nanoTime();
			tickDelta += (now - lastTime);
			lastTime = now;
			while (tickDelta >= ns && engine.gameover == false) {
				if (input.getLength() > 0) {
					int[] keys = input.getKeys();
					engine.tick(keys);
				} else {
					engine.tick();
				}

				ticks++;
				tickDelta -= ns;
			}
			repaint();
			frames++;
			// outputs the ticks and fps to the title
			if (System.currentTimeMillis() - timer > 1000) {
				// Add frame and tick showing
				aliveTime = (int) (System.currentTimeMillis() - startTime) / 1000;
				timer += 1000;
				ticks = 0;
				frames = 0;

			}

		}
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		thread = null;
	}

}