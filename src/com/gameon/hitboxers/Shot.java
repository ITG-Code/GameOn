package com.gameon.hitboxers;

import java.awt.Graphics2D;
import java.awt.Image;

public class Shot extends Hitboxer {
	byte color;
	
	public Shot(Image image, Player p, byte type) {
		super(image);
		this.x = p.x + 37;
		this.y = p.y - 80;
		this.width = 27;
		this.height = 69;
		this.color= type;
		
	}
	public void move(){
		y-=25;
	}
	public void draw(Graphics2D g){
		g.drawImage(image, x, y, width, height, null);
	}
	private byte type;
	private double vel;
	
}