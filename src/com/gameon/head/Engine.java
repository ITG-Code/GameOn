package com.gameon.head;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

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

	public Engine(String OS) {
		if (OS.indexOf("win") >= 0) {
			rl = new ResourceLoader("\\");
		} else if (OS.indexOf("linux") >= 0) {
			rl = new ResourceLoader("/");
		} else if (OS.indexOf("Mac") >= 0) {
			rl = new ResourceLoader("Mac");
		}

		this.p = new Player(rl.getShip(), null);
		this.sn = new SuperNova(rl.getShip(), null);
		enemies.add(new Enemy(rl.getRedEnemy(), null));
	}
	public void tick() {
		despawn();
		move();
		killHit();
	}
	public void tick(int[] keys) {
		despawn();
		inputMovement(keys);
		move();
		killHit();
	}

	private void inputMovement(int[] keys) {
		for (int key : keys) {

			if (key == 65 || key == 97) {// A
				// p.moveLeft();
				p.moveLeft();
			}
			if (key == 68 || key == 100) {// D
				// p.moveRight();
				p.moveRight();
			}
			if (key == 83 || key == 115) { // S
				// p.userDecelarate();
			}
			if (key == 87 || key == 119) { // W
				//p.accelarate();
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

	private void move() {
		
		sn.addDistance();
		p.addDistance();
		if (enemies != null) {
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).move(p.getSpeed());
			}
		}

		for (int i = 0; i < shots.size(); i++) {
			shots.get(i).move();
		}
		// Add deathAnimation
		

	}

	
	private void despawn(){
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getX() <= -100 || enemies.get(i).getX() >= 1300 || enemies.get(i).getY() <= -100 || enemies.get(i).getY() >= 750  || enemies.get(i).isKilled()) {
				enemies.remove(i);
			}
		}
		for (int i = 0; i < shots.size(); i++) {
			if (shots.get(i).getX() <= -100 || shots.get(i).getX() >= 1300 || shots.get(i).getY() <= -100 || shots.get(i).getY() >= 750) {
				shots.remove(i);
			}
		}
		
	}
	private void killHit() {
		// Detects any enemy that has crashed into the player
		for (int i = 0; i < enemies.size(); i++) {
			if (collisionDetect(enemies.get(i), p)) {
					enemies.remove(i);
					p.kill();
				}
				for(int j = 0; j < shots.size(); j++){
					if(collisionDetect(enemies.get(i), shots.get(j))){
						enemies.remove(i);
						shots.remove(j);
					}
				}
		}

	}
	
	private boolean collisionDetect(Hitboxer hb1, Hitboxer hb2) {
		/*Rectangle2D.Float rect1 = new Rectangle2D.Float((float)hb2.getX(), (float)hb2.getY(), (float)hb2.getWidth(), (float)hb2.getHeight());
		Rectangle2D.Float rect2 = new Rectangle2D.Float((float)hb2.getX(), (float)hb2.getY(), (float)hb2.getWidth(), (float)hb2.getHeight());
		if (rect1.intersects(rect2)) {
			System.out.println("hit");
			return true;
		} else {
			return false;
		}*/
		System.out.println(hb1.getY() + " vs " + hb2.getY());
		if(hb1.getY() + hb1.getHeight() > hb2.getY() && hb1.getY() < hb2.getY() && hb1.getX() + hb1.getWidth() > hb2.getX() && hb1.getX() < hb2.getX()){
			return true;
		}
		else{
			return false;
		}
	}

	public void greenShot() {
		shots.add(new Shot(rl.getGreenShot(),null , p, (byte) 1));
	}

	public void redShot() {
		shots.add(new Shot(rl.getRedShot(), null, p, (byte) 2));
	}

	public void blueShot() {
		shots.add(new Shot(rl.getBlueShot(), null, p, (byte) 3));
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
	public Player getP() {
		return p;
	}
	public SuperNova getSn() {
		return sn;
	}
	public Image getBackground(){
		return rl.getBackground();
	}
}
