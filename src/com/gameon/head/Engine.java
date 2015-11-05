package com.gameon.head;

import java.util.LinkedList;

import com.gameon.hitboxers.Enemy;
import com.gameon.hitboxers.Player;
import com.gameon.hitboxers.Shot;
import com.gameon.hitboxers.SuperNova;

public class Engine {
	public Player p;
	public SuperNova sn;
	public LinkedList <Enemy> enemies = new LinkedList<Enemy>();
	public LinkedList <Shot> shots = new LinkedList<Shot>();
	private ResourceLoader rl;
	public Engine(ResourceLoader rl){
		this.rl = rl;
		this.p = new Player(rl.getShip());
		this.sn = new SuperNova(rl.getShip());
	}
	
	public void tick(){
		removeExcess();
		move();
		//int[] inputs = input.getInputs();
		//int[] inputs = getInputs();
		
		//Removes all the enemies outside playarea 
		
		
	}
	private void removeExcess(){
		for(int i = 0; i < enemies.size(); i++){
			if(enemies.get(i).getX() <= 50 || enemies.get(i).getX() >= 1300 || enemies.get(i).getY() <= 50 || enemies.get(i).getY() >= 750){
				enemies.remove(i);
			}
		}
		for(int i = 0; i < enemies.size();i++){
			if(shots.get(i).getX() <= 50 || shots.get(i).getX() >= 1300 || shots.get(i).getY() <= -69 || shots.get(i).getY() >= 750){
				shots.remove(i);
			}
		}
		
		
	}
	private void move(){
		sn.addDistance();
		p.addDistance();
		if(enemies != null ){
			for(int i = 0; i < enemies.size();i++){
				Enemy e = enemies.get(i);
				enemies.removeFirst();
				e.move(p.getSpeed());
				enemies.add(e);
			}
		}

		for(int i = 0; i < shots.size();i++){
			Shot s = shots.get(i);
			shots.removeFirst();
			s.move();
			shots.add(s);
		}
		enemies.add(new Enemy(rl.getRedEnemy())); 
		
	}
	
	public void greenShot(){
		shots.add(new Shot(rl.getGreenShot(), p, (byte)1));
	}
	public void redShot(){
		shots.add(new Shot(rl.getRedShot(), p, (byte)2));
	}
	public void blueShot(){
		shots.add(new Shot(rl.getBlueShot(), p, (byte)3));
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
}
