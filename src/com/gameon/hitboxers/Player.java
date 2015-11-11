package com.gameon.hitboxers;

import java.awt.Graphics2D;
import java.awt.Image;

public class Player extends Speeder {
	private Image leftImage;
	private Image rightImage;
	public Player(Image image, Image[] da, Image[] lar) {
		super(image, da);
		this.x = 600;
		this.y = 550;
		this.width = 100;
		this.height = 40;
		this.leftImage = lar[0];
		this.rightImage = lar[2];
	}
	public void draw(Graphics2D g) {
		/*
		 * if (isKilled()) { if(!(getDeathAnimation().length <
		 * getDeathState())){ g.drawImage(getDeathAnimation()[getDeathState()],
		 * x +(95*getLane()), y, width, height, null);
		 * setDeathState(getDeathState() + 1); } } else {
		 */
		int lane = getLane();
		if (lane == 3){
			lane = 2;
			g.drawImage(this.rightImage, x + (95 * lane), y, width, height, null);
		}
			
		if (lane == 1){
			lane = 0;
			g.drawImage(getImage(), x + (95 * lane), y, width, height, null);
		}
			
		if (lane == -1){
			lane = -2;
			g.drawImage(this.leftImage, x + (95 * lane), y, width, height, null);
		}
			
		
		// (540 + (100 * getLane()))

		// }

	}
	public void moveLeft() {
		move();
		if(getLane() >= 0){
			setLane(getLane() - 1);
		}
		
	}

	public void moveRight() {
		move();
		if(getLane() <=2){
			setLane(getLane() + 1);
		}
		
	}

	public Image getLeftImage() {
		return leftImage;
	}

	public Image getRightImage() {
		return rightImage;
	}
}