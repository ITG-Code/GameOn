package com.gameon.hitboxers;

import java.awt.Graphics;
import java.awt.Image;
 
public class Player extends Speeder {

	public Player(Image image) {
		super(image);
		
	}

	public void addDistance() {
		// TODO Auto-generated method stub
		
	}
	public void draw(Graphics g){
		g.drawImage(this.image, x, y, width, height, null);
	}
}