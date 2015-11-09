package com.gameon.hitboxers;

import java.awt.Image;

public class Player extends Speeder {
	private byte lane;
	public Player(Image image, Image[] da) {
		super(image, da);
		this.x = 600;
		this.y = 550;
		this.lane = 0;
	}

	public void moveLeft() {
		this.x -= 40;
		lane--;
	}

	public void moveRight() {
		this.x += 40;
		lane++;
	}
}