package com.gameon.hitboxers;

import java.awt.Graphics2D;
import java.awt.Image;

public class Shot extends Hitboxer {
	byte color;
	
	public Shot(Image image, Image[] da, Player p, byte type) {
		super(image, da);
		this.x = p.x + 37;
		this.setLane(p.getLane());
		this.y = p.y - 80;
		this.width = 27;
		this.height = 69;
		this.color= type;
	}
	public void move(){
		y-=20;
	}
	public void draw(Graphics2D g) {
		if (isKilled()) {
			if(!(getDeathAnimation().length < getDeathState())){
				g.drawImage(getDeathAnimation()[getDeathState()], (540 + (100 * getLane())), y, width, height, null);
				setDeathState(getDeathState() + 1);
			}
		} else {
			g.drawImage(getImage(), (540 + (100 * getLane())), y, width, height, null);
		}

	}
	
}