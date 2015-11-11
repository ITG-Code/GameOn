package com.gameon.head;

import java.awt.Image;
import java.util.LinkedList;
import java.util.Random;

import com.gameon.hitboxers.Enemy;
import com.gameon.hitboxers.Hitboxer;
import com.gameon.hitboxers.Player;
import com.gameon.hitboxers.Shot;
import com.gameon.hitboxers.SuperNova;

public class Engine {
	private Player p;
	private SuperNova sn;
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	private LinkedList<Shot> shots = new LinkedList<Shot>();
	private ResourceLoader rl;
	private int score = 0;
	private float speed = 1;
	private double minimumSpeed = 0.5;

	private float multiplier = 1;
	private long lastSpawn = 0;

	public boolean gameover = false;

	// Initiates the engine class
	public Engine(String OS) {
		// loads a different kind of Resouceloader depending on the OS the
		// application is running on
		if (OS.indexOf("win") >= 0) {
			rl = new ResourceLoader("\\");
		} else if (OS.indexOf("linux") >= 0) {
			rl = new ResourceLoader("/");
		} else if (OS.indexOf("Mac") >= 0) {
			rl = new ResourceLoader("Mac");
		}

		this.p = new Player(rl.getShip()[1], null, rl.getShip());
		// enemies.add(new Enemy(rl.getGreenEnemy(), rl.getRedDeath()));
	}

	// When called the method does one engine cycle without input
	public void tick() {
		speedCheck();
		despawn();
		spawn();
		move();
		killHit();
	}

	// When called the method does one engine cycle with input
	public void tick(int[] keys) {
		speedCheck();
		despawn();
		spawn();
		inputMovement(keys);
		move();
		killHit();
	}

	private void speedCheck() {
		/*
		 * minimumSpeed+=0.0003; if(minimumSpeed => )
		 */
	}

	// Handles the input such as movement and shooting
	private void inputMovement(int[] keys) {
		for (int key : keys) {

			if (key == 65 || key == 97) {// A
				p.moveLeft();
			}
			if (key == 68 || key == 100) {// D
				p.moveRight();
			}
			if (key == 83 || key == 115) { // S
				speed *= 0.98;
			}
			if (key == 87 || key == 119) { // W
				speed *= 1.02;
			}
			if (key == 66 || key == 98) { // B
				greenShot();
			}
			if (key == 78 || key == 110) { // N
				redShot();
			}
			if (key == 77 || key == 109) { // M
				blueShot();
			}

		}

	}

	// Moves the enemies and shots
	private void move() {
		if (enemies != null) {	
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).move(speed);
			}
		}

		for (int i = 0; i < shots.size(); i++) {
			shots.get(i).move(speed);
		}
		// Add deathAnimation

	}

	// Removes all the enemies and shots outside the screen area
	private void despawn() {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getX() <= -100 || enemies.get(i).getX() >= 1300 || enemies.get(i).getY() <= -100
					|| enemies.get(i).getY() >= 750 || enemies.get(i).isKilled()) {
				enemies.remove(i);
			}
		}
		for (int i = 0; i < shots.size(); i++) {
			if (shots.get(i).getX() <= -100 || shots.get(i).getX() >= 1300 || shots.get(i).getY() <= -100
					|| shots.get(i).getY() >= 750) {
				shots.remove(i);
			}
		}

	}

	// Spawns a a new random enemy in a random lane every second
	private void spawn() {

		Random r = new Random();

		if (lastSpawn + 1000000000 < System.nanoTime()) {
			lastSpawn = System.nanoTime();
			int lane = r.nextInt(3);
			int type = r.nextInt(3);
			System.out.println("Lane: " + lane + " type: type");
			if (type == 0) {
				enemies.add(new Enemy(rl.getGreenEnemy(), rl.getGreenDeath(), type, lane));
			}
			if (type == 1) {
				enemies.add(new Enemy(rl.getRedEnemy(), rl.getRedDeath(), type, lane));
			}
			if (type == 2) {
				enemies.add(new Enemy(rl.getBlueEnemy(), rl.getBlueDeath(), type, lane));
			}

		}

	}

	private void killHit() {
		// Detects any enemy that has crashed into the player
		for (int i = 0; i < enemies.size(); i++) {
			if (detectHit(enemies.get(i), p)) {
				enemies.remove(i);
				this.gameover = true;
			}
			for (int j = 0; j < shots.size(); j++) {
				if (detectHit(enemies.get(i), shots.get(j))) {
					if (enemies.get(i).getType() == shots.get(j).getType()) {
						enemies.remove(i);
						shots.remove(j);
						multiplier++;
						makeScore();
						break;
					} else {
						shots.get(j).reverse();
						multiplier = 0;
					}

				}
				if (detectHit(shots.get(j), p)) {
					this.gameover = true;
				}
			}
		}

	}

	// Detects if two Hitboxes are placed over each other
	private boolean detectHit(Hitboxer hb1, Hitboxer hb2) {
		if (hb1.getY() + hb1.getHeight() > hb2.getY() && hb1.getY() < hb2.getY() && hb1.getLane() == hb2.getLane()) {
			return true;
		} else {
			return false;
		}
	}

	// Adds score based on gameSpeed and multiplier
	private void makeScore() {
		score++;
	}

	public void greenShot() {
		shots.add(new Shot(rl.getGreenShot(), null, p, 0));
	}

	public void redShot() {
		shots.add(new Shot(rl.getRedShot(), null, p, 1));
	}

	public void blueShot() {
		shots.add(new Shot(rl.getBlueShot(), null, p, 2));
	}

	public Player getPlayer() {
		return p;
	}

	public LinkedList<Enemy> getEnemies() {
		return enemies;
	}

	public LinkedList<Shot> getShots() {
		return shots;
	}

	public SuperNova getSuperNova() {
		return sn;
	}

	public Image getBackground() {
		return rl.getBackground();
	}

	public Image getGameOver() {
		return rl.getGameOver();
	}

	public Image getLines() {
		return rl.getLines();
	}

	public int getScore() {
		return score;
	}

}
