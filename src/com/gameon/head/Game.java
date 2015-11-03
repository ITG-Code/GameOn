package com.gameon.head;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.gameon.graphical.GamePanel;


public class Game extends JFrame{
	

	public final int width = 640;
	public final int height = width / 16 *9;
	JPanel panel;
	Graphics2D g;
	
	
	public Game(){
		this.setTitle("GameOn!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(this.width,this.height));
		this.setMinimumSize(new Dimension(640,360));
		this.setMaximumSize(new Dimension(1920,1080));
		panel = new GamePanel();
		
		this.add(panel);
		this.pack();
		this.setVisible(true);
		startGame();
		while(true){
			panel.paint(g);
		}
	}
	public static void main(String[] args){
		new Game();
		
	}
	public void startGame(){
		
	}
	
}
