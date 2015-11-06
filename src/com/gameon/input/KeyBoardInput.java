package com.gameon.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyBoardInput extends KeyAdapter {
	/**
	 * 
	 * the class collects keyStrokes and then deletes them after they've been sent 
	 * 	
	**/
	private LinkedList<Integer> pressedKeys = new LinkedList<Integer>();

	public int[] getKeys() {
		if (pressedKeys.isEmpty()) {
			return new int[0];
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
		System.out.println(e.getKeyChar());
		pressedKeys.add((int) e.getKeyChar());
		e.consume();
	}

	public void keyTyped(KeyEvent e) {
		pressedKeys.add((int) e.getKeyChar());
		e.consume();
	}

	public void keyReleased(KeyEvent e) {
		e.consume();
	}

}