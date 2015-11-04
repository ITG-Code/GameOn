package com.gameon.head;

import com.gameon.hitboxers.Enemy;
import com.gameon.hitboxers.Player;
import com.gameon.hitboxers.SuperNova;

public class Engine {
	private Player p;
	private SuperNova sn;
	private Enemy[] enemies;
	private int playerMoves;
	public Engine(){
		
	}
	public void tick(){
		System.out.println("Hi");
		/*int[] inputs = input.getInputs();
		sn.addDistance();
		p.addDistance();
		for(int i = 0; i < enemies.length;i++){
			enemies[i].move(p.getSpeed());
		}
		for(int i = 0; i < inputs.length;i++){
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
				greenShot();
			}
			if(inputs[i] == 78){ // N
				redShot();
			}
			if(inputs[i] == 77){ // M
				blueShot();
			}
		} */
	}
	private void blueShot(){
		
	}
}
