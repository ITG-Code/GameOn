package com.gameon.head;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResourceLoader {
	private Image background;
	private Image[] ship = new Image[3];

	private Image redEnemy;
	private Image blueEnemy;
	private Image greenEnemy;

	private Image redShot;
	private Image blueShot;
	private Image greenShot;

	private Image[] blue_death;
	private Image[] red_death;
	private Image[] green_death;

	private Image lines;
	private Image gameOver;
	
	//Loads images into the game
	public ResourceLoader(String r) {

		String[] imageLocations = { "images\\background.png", "images\\ship.png", "images\\asteroid.png",

				"images\\red_mob.png", "images\\blue_mob.png", "images\\green_mob.png",

				"images\\blue_shot.png", "images\\red_shot.png", "images\\green_shot.png",

				"images\\lines.png",

				"images\\red_death\\1.png", "images\\red_death\\2.png", "images\\red_death\\3.png",
				"images\\red_death\\4.png", "images\\red_death\\5.png", "images\\red_death\\6.png",
				"images\\red_death\\7.png", "images\\red_death\\8.png", "images\\red_death\\9.png",
				"images\\red_death\\10.png", "images\\red_death\\11.png", "images\\red_death\\12.png",
				"images\\red_death\\13.png", "images\\red_death\\14.png", "images\\red_death\\15.png",
				"images\\red_death\\16.png", "images\\red_death\\17.png", "images\\red_death\\18.png",
				"images\\red_death\\19.png", "images\\red_death\\20.png", "images\\red_death\\21.png",
				"images\\red_death\\22.png", "images\\red_death\\23.png", "images\\red_death\\24.png",

				"images\\green_death\\1.png", "images\\green_death\\2.png", "images\\green_death\\3.png",
				"images\\green_death\\4.png", "images\\green_death\\5.png", "images\\green_death\\6.png",
				"images\\green_death\\7.png", "images\\green_death\\8.png", "images\\green_death\\9.png",
				"images\\green_death\\10.png", "images\\green_death\\11.png", "images\\green_death\\12.png",
				"images\\green_death\\13.png", "images\\green_death\\14.png", "images\\green_death\\15.png",
				"images\\green_death\\16.png", "images\\green_death\\17.png", "images\\green_death\\18.png",
				"images\\green_death\\19.png", "images\\green_death\\20.png", "images\\green_death\\21.png",
				"images\\green_death\\22.png", "images\\green_death\\23.png", "images\\green_death\\24.png",

				"images\\blue_death\\1.png", "images\\blue_death\\2.png", "images\\blue_death\\3.png",
				"images\\blue_death\\4.png", "images\\blue_death\\5.png", "images\\blue_death\\6.png",
				"images\\blue_death\\7.png", "images\\blue_death\\8.png", "images\\blue_death\\9.png",
				"images\\blue_death\\10.png", "images\\blue_death\\11.png", "images\\blue_death\\12.png",
				"images\\blue_death\\13.png", "images\\blue_death\\14.png", "images\\blue_death\\15.png",
				"images\\blue_death\\16.png", "images\\blue_death\\17.png", "images\\blue_death\\18.png",
				"images\\blue_death\\19.png", "images\\blue_death\\20.png", "images\\blue_death\\21.png",
				"images\\blue_death\\22.png", "images\\blue_death\\23.png", "images\\blue_death\\24.png", 
				
				"images\\game_over.png",
				"images\\ship_left.png",
				"images\\ship_right.png"
		
		};
				/*
				 * for(int i = 0; i < imageLocations.length;i++){
				 * imageLocations[i] = imageLocations[i].replaceAll("/", r);
				 * 
				 * }
				 */

		// Loads the background image
		background = new ImageIcon(imageLocations[0]).getImage();
		ship[1] = new ImageIcon(imageLocations[1]).getImage();

		redEnemy = new ImageIcon(imageLocations[3]).getImage();
		blueEnemy = new ImageIcon(imageLocations[4]).getImage();
		greenEnemy = new ImageIcon(imageLocations[5]).getImage();

		blueShot = new ImageIcon(imageLocations[6]).getImage();
		redShot = new ImageIcon(imageLocations[7]).getImage();
		greenShot = new ImageIcon(imageLocations[8]).getImage();

		lines = new ImageIcon(imageLocations[9]).getImage();

		red_death = new Image[24];
		for (int i = 0; i < 23; i++) {
			red_death[i] = new ImageIcon(imageLocations[10 + i]).getImage();
		}
		green_death = new Image[24];
		for (int i = 0; i < 23; i++) {
			green_death[i] = new ImageIcon(imageLocations[34 + i]).getImage();
		}
		blue_death = new Image[24];
		for (int i = 0; i < 23; i++) {
			blue_death[i] = new ImageIcon(imageLocations[58 + i]).getImage();
		}
		gameOver = new ImageIcon(imageLocations[82]).getImage();
		ship[0] = new ImageIcon(imageLocations[83]).getImage();
		ship[2] = new ImageIcon(imageLocations[84]).getImage();
		System.out.println(background.getWidth(null));

	}

	public Image getBackground() {

		return background;
	}

	public Image[] getShip() {
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

	public Image getLines() {
		return lines;
	}

	public Image[] getBlueDeath() {
		return blue_death;
	}

	public Image[] getRedDeath() {
		return red_death;
	}

	public Image[] getGreenDeath() {
		return green_death;
	}

	public Image getGameOver() {
		return gameOver;
	}

}
