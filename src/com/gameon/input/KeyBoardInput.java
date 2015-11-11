package com.gameon.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyBoardInput extends KeyAdapter {
	/**
	 * 
	 * the class collects keyStrokes and then deletes them after they've been
	 * sent
	 * 
	 **/
	private LinkedList<Integer> pressedKeys = new LinkedList<Integer>();

	public int getLength() {
		return this.pressedKeys.size();
	}
	
	//Returns an array of the keys that has been pressed since the last call of this method
	public int[] getKeys() {

		if (pressedKeys.isEmpty()) {
			int[] a = { 0 };
			return a;
		} else {
			int[] a = new int[pressedKeys.size()];
			for (int i = 0; i < a.length; i++) {
				a[i] = pressedKeys.get(i);
			}
			pressedKeys.clear();
			return a;
		}

	}
	//collects input and puts the input into the list if it's not already added
	public void keyPressed(KeyEvent e) {
		boolean clear = true;
		for(int i = 0; i < pressedKeys.size(); i++){
			if(pressedKeys.equals((int) e.getKeyChar())){
				clear = false;
				break;
			}
		}
		if(clear){
			pressedKeys.add((int) e.getKeyChar());
			e.consume();
		}
		
	}
	//collects input and puts the input into the list if it's not already added
	public void keyTyped(KeyEvent e) {
		boolean clear = true;
		for(int i = 0; i < pressedKeys.size(); i++){
			if(pressedKeys.equals((int) e.getKeyChar())){
				clear = false;
				break;
			}
		}
		if(clear){
			pressedKeys.add((int) e.getKeyChar());
			e.consume();
		}
		
	}
	//Gets rid of the released keys 
	public void keyReleased(KeyEvent e) {
		e.consume();
	}

}