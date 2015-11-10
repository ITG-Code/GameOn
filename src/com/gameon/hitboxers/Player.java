package com.gameon.hitboxers;

import java.awt.Image;

public class Player extends Speeder {
	public Player(Image image, Image[] da) {
		super(image, da);
		this.x = 600;
		this.y = 550;
		this.width = 100;
		this.height = 40;
	}

	public void moveLeft() {
		if(getLane() >= 0){
			setLane(getLane() - 1);
		}
		
	}

	public void moveRight() {
		if(getLane() <=2){
			setLane(getLane() + 1);
		}
		
	}
}