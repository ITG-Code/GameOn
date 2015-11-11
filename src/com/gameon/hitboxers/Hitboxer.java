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
	private int deathState = 0;
	private final double max = 3.1;
	private int lane;

	public Hitboxer(Image image, Image[] deathAnimation) {
		this.image = image;
		x = 100;
		y = 100;
		width = 100;
		height = 100;
		if (deathAnimation == null) {
			deathAnimation = new Image[0];
		} else {
			this.deathAnimation = deathAnimation;
		}

		this.lane = 1;
	}

	// moves the Hitboxer diagonally if the Hitboxers lane is -1 or 3 and moves
	// strait down if it's 1
	public void move() {
		int grad = 0;
		if (getLane() == 3)
			grad = 250;
		if (getLane() == 1)
			grad = 270;
		if (getLane() == -1)
			grad = 290;

		x += 15 * Math.cos(Math.toRadians(grad));
		y += 15 * Math.sin(Math.toRadians(grad));

	}
	//Draws image of the Hitboxer
	public void draw(Graphics2D g) {
		/*
		 * if (isKilled()) { if(!(getDeathAnimation().length <
		 * getDeathState())){ g.drawImage(getDeathAnimation()[getDeathState()],
		 * x +(95*getLane()), y, width, height, null);
		 * setDeathState(getDeathState() + 1); } } else {
		 */
		int lane = getLane();
		if (lane == 3)
			lane = 2;
		if (lane == 1)
			lane = 0;
		if (lane == -1)
			lane = -2;
		g.drawImage(getImage(), x + (95 * lane), y, width, height, null);
		// (540 + (100 * getLane()))

		// }

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

	public boolean isKilled() {
		if (this.killed && this.deathAnimation.length <= this.deathState) {
			return true;
		} else {
			return false;
		}

	}

	public int getDeathState() {
		return deathState;
	}

	public double getMax() {
		return max;
	}

	protected Image getImage() {
		return image;
	}

	protected void setImage(Image image) {
		this.image = image;
	}

	protected Image[] getDeathAnimation() {
		return deathAnimation;
	}

	protected void setDeathAnimation(Image[] deathAnimation) {
		this.deathAnimation = deathAnimation;
	}

	protected void setX(int x) {
		this.x = x;
	}

	protected void setY(int y) {
		this.y = y;
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	protected void setKilled(boolean killed) {
		this.killed = killed;
	}

	protected void setDeathState(int i) {
		this.deathState = i;
	}

	public int getLane() {
		return lane;
	}

	protected void setLane(int lane) {
		this.lane = lane;
	}
}