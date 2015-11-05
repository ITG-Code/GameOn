package com.gameon.head;

import java.awt.Image;

import javax.swing.ImageIcon;
public class ResourceLoader {
		private Image background;
		private Image[] ship;
		
		
		
	public ResourceLoader(String r){
		
		String[] imageLocations = {
				"images\\background.jpg"
				
		};
		/*
		for(int i = 0; i < imageLocations.length;i++){
			imageLocations[i] = imageLocations[i].replaceAll("/", r);
			
		}
		*/
		
		//Loads the background image
		background = new ImageIcon(imageLocations[0]).getImage();
		
		
		
		
		System.out.println(background.getWidth(null));
		
	}
	public Image getBackground(){
		
		return background;
	}
	public Image[] getShip() {
		return ship;
	}
	
}
