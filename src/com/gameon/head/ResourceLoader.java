package com.gameon.head;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResourceLoader {
		private Image background;
		private Image[] ship;
	public ResourceLoader(){
		background = new ImageIcon("background.jpg").getImage();
	}
	public Image getBackground(){
		return background;
	}
	public Image[] getShip() {
		return ship;
	}
	
}
