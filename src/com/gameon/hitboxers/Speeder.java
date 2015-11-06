package com.gameon.hitboxers;

import java.awt.Image;

public class Speeder extends Hitboxer {

	private int distance = 0;
	private double speed = 1;

	public Speeder(Image image, Image[] da) {
		super(image, da);
	}

	public void move() {

		// Add left and right movement
	}

	public void addDistance() {
		distance += (int) speed;
	}

	public double getSpeed() {
		return this.speed;
	}
}
