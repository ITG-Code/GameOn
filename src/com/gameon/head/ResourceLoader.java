package com.gameon.head;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResourceLoader {
	private Image background;
	private Image ship;

	private Image redEnemy;
	private Image blueEnemy;
	private Image greenEnemy;

	private Image redShot;
	private Image blueShot;
	private Image greenShot;

	public ResourceLoader(String r) {

		String[] imageLocations = { 
				"images\\background.png", 
				"images\\ship.png", 
				"images\\asteroid.png",

				"images\\red_mob.png", 
				"images\\blue_mob.png", 
				"images\\green_mob.png",

				"images\\blue_shot.png", 
				"images\\red_shot.png", 
				"images\\green_shot.png" 
				};
				/*
				 * for(int i = 0; i < imageLocations.length;i++){
				 * imageLocations[i] = imageLocations[i].replaceAll("/", r);
				 * 
				 * }
				 */

		// Loads the background image
		background = new ImageIcon(imageLocations[0]).getImage();
		ship = new ImageIcon(imageLocations[1]).getImage();

		redEnemy = new ImageIcon(imageLocations[3]).getImage();
		blueEnemy = new ImageIcon(imageLocations[4]).getImage();
		greenEnemy = new ImageIcon(imageLocations[5]).getImage();

		blueShot = new ImageIcon(imageLocations[6]).getImage();
		redShot = new ImageIcon(imageLocations[7]).getImage();
		greenShot = new ImageIcon(imageLocations[8]).getImage();

		System.out.println(background.getWidth(null));

	}

	public Image getBackground() {

		return background;
	}

	public Image getShip() {
		return ship;
	}

	public Image getRedEnemy() {
		return redEnemy;
	}

	public Image getBlueEnemy() {
		return blueEnemy;
	}

	public Image getGreenEnemy() {
		return greenEnemy;
	}

	public Image getRedShot() {
		return redShot;
	}

	public Image getBlueShot() {
		return blueShot;
	}

	public Image getGreenShot() {
		return greenShot;
	}

}
