package com.gameon.head;

import java.awt.Image;

import javax.swing.ImageIcon;
public class ResourceLoader {
		private Image background;
		private Image ship;
		private Image shot;
		private Image redEnemy;
		
	public ResourceLoader(String r){
		
		String[] imageLocations = {
				"images\\background.png",
				"images\\ship.png",
				"images\\asteroid.png",
				"images\\red_mob.png",
				"",
				"",
				"images\\blue_shot.png",
				"",
				""
		};
		/*
		for(int i = 0; i < imageLocations.length;i++){
			imageLocations[i] = imageLocations[i].replaceAll("/", r);
			
		}
		*/
		
		//Loads the background image
		background = new ImageIcon(imageLocations[0]).getImage();
		ship = new ImageIcon(imageLocations[1]).getImage();
		shot = new ImageIcon(imageLocations[6]).getImage();
		redEnemy = new ImageIcon(imageLocations[3]).getImage();
		
		System.out.println(background.getWidth(null));
		
	}
	public Image getBackground(){
		
		return background;
	}
	public Image getShip() {
		return ship;
	}
	public Image getShot(){
		return shot;
	}
	public Image getRedEnemy(){
		return redEnemy;
	}
	
}
