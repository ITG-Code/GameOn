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

	public void keyTyped(KeyEvent e) {
		pressedKeys.add((int) e.getKeyChar());
		e.consume();
	}

	public void keyReleased(KeyEvent e) {
		e.consume();
	}

}