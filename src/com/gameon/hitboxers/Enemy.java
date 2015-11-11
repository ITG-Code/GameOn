package com.gameon.hitboxers;

import java.awt.Graphics2D;
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
		this.type = type;
	}
	
	
	public void move(double amount) {
		int grad = 0;
        if(getLane() == 3)
                grad = 229;
        if(getLane() == 1)
                grad = 270;
        if (getLane()== -1)
                grad = 280;
		 this.x -= 3 * Math.cos(Math.toRadians(grad));
		 this.y -= 3 * Math.sin(Math.toRadians(grad));
		
	}

	public boolean hit() {
		return true;
	}
	public void draw(Graphics2D g){
		
		g.drawImage(getImage(),x,y, width/3 + y/6, height/3 + y/6, null);
	}
	

	public int getType() {
		return type;
	}
}