package com.gameon.hitboxers;

import java.awt.Image;

public class Enemy extends Hitboxer {
	private boolean alive = true;
	public Enemy(Image bild) {
		super(bild);
		x = 600;
		y = 20;
	}
	public void move(double amount){
		
	}
	public boolean hit(){
		return true;
	}

}
