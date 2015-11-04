package com.gameon.hitboxers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

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
	
	public void drawArrow(Graphics2D g)
	{
		AffineTransform transform = new AffineTransform();
		g.drawImage(image,x,y, width, height, null);
		transform.setToIdentity();
		
	}
}