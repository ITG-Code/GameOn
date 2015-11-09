package com.gameon.hitboxers;

import java.awt.Image;

public class Shot extends Hitboxer {
	byte color;
	
	public Shot(Image image, Image[] da, Player p, byte type) {
		super(image, da);
		this.x = p.x + 37;
		this.y = p.y - 80;
		this.width = 27;
		this.height = 69;
		this.color= type;
	}
	public void move(){
		y-=20;
	}
	
}