package com.gameon.head;

import com.gameon.hitboxers.Enemy;
import com.gameon.hitboxers.Player;
import com.gameon.hitboxers.Shot;
import com.gameon.hitboxers.SuperNova;
import com.gameon.input.KeyBoardInput;

public class Engine {
	private Player p;
	private SuperNova sn;
	private Enemy[] enemies;
	private Shot[] shots;
	private int playerMoves;
	private KeyBoardInput input = new KeyBoardInput();
	
	public Engine(){
		
	}
	
	public void tick(){
		/*System.out.println("Hi");
		//int[] inputs = input.getInputs();
		sn.addDistance();
		p.addDistance();
		for(int i = 0; i < enemies.length;i++){
			enemies[i].move(p.getSpeed());
		}
		if(inputs.length > 0){
			for(int i = 0; i < inputs.length;i++){
				System.out.println((char) inputs[i]);
				if(inputs[i] == 65){// A
					//p.moveLeft();
				}
				if(inputs[i] == 68){// D
					//p.moveRight();
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
			}
		}
		*/
	}
	private void blueShot(){
		
	}
}
