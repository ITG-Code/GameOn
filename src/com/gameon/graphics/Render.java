package com.gameon.graphics;

import java.util.Random;

public class Render {
	private int width; 
	private int height;
	public int[] pixels;
	public int[] tiles = new int[64 * 64];
	
	private Random r = new Random();
	
	
	public Render(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < tiles.length; i++){
			tiles[i] = r.nextInt(0xffffff);
		}
		
	}
	public void clear(){
		for(int i = 0; i < pixels.length;i++){
						//Binary for 0
			pixels[i] = 0b0;
		}
	}
	//Renders a frame
	public void rend(){
		for(int y = 0; y < height;y++){
			if(y < 0 || y >= height){
				break;
			}
			for(int x = 0;x < width;x++){
				if(x < 0 || x >= width){
					break;
				}
									// x >> 4 == x / 2^4
				int tileIndex = (x >> 4) + (y >> 4) * 64;
				//Fills the pixel (x,y) with the color Pink FF00FF
				pixels[x + y * width] = tiles[tileIndex];
				
			}
		}
	}
	public int getPixel(int index){
		return pixels[index];
	}
	
}
