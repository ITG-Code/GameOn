package com.gameon.hitboxers;

import java.awt.Graphics2D;
import java.awt.Image;

public class Hitboxer {

	private Image image;
	private Image[] deathAnimation;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	private boolean killed = false;
	private byte deathState = 0;
	private final double max = 3.1;

	public Hitboxer(Image image, Image[] deathAnimation) {
		this.image = image;
		x = 100;
		y = 100;
		width = 100;
		height = 100;
		this.deathAnimation = deathAnimation;

	}

	public void draw(Graphics2D g) {
		if (killed) {
			if(!(deathAnimation.length < deathState)){
				g.drawImage(deathAnimation[deathState], x, y, width, height, null);
				deathState++;
			}
		} else {
			g.drawImage(image, x, y, width, height, null);
		}

	}

	public boolean killed() {
		return killed;
	}

	public void kill() {
		this.killed = true;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}