package com.gameon.graphics;

public class Render {
	private int width; 
	private int height;
	public int[] pixels;
	
	public Render(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
	}
	public void clear(){
		for(int i = 0; i < pixels.length;i++){
						//Binary for 0
			pixels[i] = 0b0;
		}
	}
	public void rend(){
		for(int y = 0; y < height;y++){
			for(int x = 0;x < width;x++){
									//Pink FF00FF
				pixels[x + (y*width)] = 0xff00ff;
			}
		}
	}
	public int getPixel(int index){
		return pixels[index];
	}
	
}
