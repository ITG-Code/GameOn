package com.gameon.hitboxers;

import java.awt.Graphics2D;
import java.awt.Image;

public class Enemy extends Hitboxer {
	private int type;
	
	public Enemy(Image image, Image[] da , int type, int lane) {
		super(image, da);
		x = 600;
		y = 20;
		this.setLane(lane);
	}

	public void move(double amount) {
		this.y += amount;
	}

	public boolean hit() {
		return true;
	}
	/*public void draw(Graphics2D g){
		g.rotate(Math.toRadians(30), width / 2, height / 2);
	}*/

	public int getType() {
		return type;
	}
}
