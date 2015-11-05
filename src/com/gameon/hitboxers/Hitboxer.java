package com.gameon.hitboxers;

import java.awt.Graphics2D;
import java.awt.Image;

public class Hitboxer {

protected Image image;
protected int x;
protected int y;
protected int width;
protected int height;

private final double max = 3.1;


	public Hitboxer(Image image)
	{
		this.image = image;
		x = 100;
		y = 100;
		width = 100;
		height = 100;
	}
	
	public void draw(Graphics2D g)
	{
		g.drawImage(image,x,y, width, height, null);

		
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