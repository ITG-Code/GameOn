package com.gameon.graphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	BufferedImage image;
	Graphics2D g;
	Image background;
	
	public GamePanel(){
		image = new BufferedImage(1280,720, BufferedImage.TYPE_INT_ARGB);
		g = image.createGraphics();
		this.setLayout(new GridLayout(1,1));
	}
	public void paint(Graphics g){
		//g.drawImage(background, 0, 0, 1280, 720, this);
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, 1280, 720);
		
	}
}
