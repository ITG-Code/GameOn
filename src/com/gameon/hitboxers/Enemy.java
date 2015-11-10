package com.gameon.hitboxers;

import java.awt.Image;

public class Enemy extends Hitboxer {
	private int type;
	
	public Enemy(Image image, Image[] da , int type, int lane) {
		super(image, da);
		x = 600;
		y = 20;
		if(lane == 0){
			this.setLane(-1);
		}
		else if(lane == 1){
			this.setLane(1);
		}
		else if(lane == 2){
			this.setLane(3);
		}
		
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
