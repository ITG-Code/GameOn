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

		//int[] inputs = input.getInputs();
		//int[] inputs = getInputs();
		int[] inputs = {87};
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
		
		//Removes all the enemies outside playarea 
		/*for(int i = 0; i < enemies.length; i++){
			if(enemies[i].getX() <= 50 || enemies[i].getX() >= 1300 || enemies[i].getY() <= 50 || enemies[i].getY() >= 750){
				Enemy[] tempE = new Enemy[enemies.length-1];
				int offset = 0;
				for(int j = 0; j < enemies.length;j++){
					if(j == i){
						offset = 1;
					}
					else{
						tempE[j-offset] = enemies[j];
					}
				}
				enemies = tempE;
			}
		}*/
		/*if(shot != null){
			shot.move();
			if(shot.getX() <= 50 || shot.getX() >= 1300 || shot.getY() <= -69 || shot.getY() >= 750){
				shot = null;
			}
		}*/
		

		if(inputs.length > 0){
			/*for(int i = 0; i < inputs.length;i++){
				if(inputs[i] == 65){// A
					p.moveLeft();
				}
				if(inputs[i] == 68){// D
					p.moveRight();
				}
				if(inputs[i] == 83){ //S
					p.userDecelarate();
				}
				if(inputs[i] == 87){ // W
					p.userAcc();
				}
				if(inputs[i] == 66){ // B
				//	greenShot();
				}
				if(inputs[i] == 78){ // N
					//redShot();
				}
				if(inputs[i] == 77){ // M
					blueShot();
				}
			}*/
		}
		
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
