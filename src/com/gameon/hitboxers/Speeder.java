package com.gameon.hitboxers;

import java.awt.Image;

public class Speeder extends Hitboxer {
	
	private int distance = 0;
	private double speed = 1;
	
	
	public Speeder(Image bild) {
		super(bild);
	}
	
	public void accelarate(){
		double speed=+0.00005;
	}
	public void userAcc(){
		double speed=+0.05;
	}
	public void userDecelarate(){
		double speed=-0.05;
	}
	public void move(){
	
		//Add left and right movement
	}
	public void addDistance(){
		distance+=(int)speed;
	}
	public double getSpeed(){
		return this.speed;
	}
}
