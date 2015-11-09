package com.gameon.hitboxers;

import java.awt.Image;

public class Enemy extends Hitboxer {

	public Enemy(Image image, Image[] da) {
		super(image, da);
		x = 600;
		y = 20;
	}

	public void move(double amount) {
		this.y += amount;
	}

	public boolean hit() {
		return true;
	}
}
