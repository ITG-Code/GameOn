package com.gameon.head;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ResourceLoader {
		private Image background;
		private Image[] ship;
	public ResourceLoader(){
		Image background = new ImageIcon("C:\\Users\\phuongnam.nguyen\\workspace\\GameOn\\src\\wallpapper.png").getImage();
		System.out.println(background.getWidth(null));
		
	}
	public Image getBackground(){
		
		return background;
	}
	public Image[] getShip() {
		return ship;
	}
	
}
