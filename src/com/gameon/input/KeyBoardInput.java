package com.gameon.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInput implements KeyListener{
	private int[] keys;
	private int[] acceptedKeys;
	@Override
	public void keyPressed(KeyEvent e) {
		int key = (int) e.getKeyChar();
		for(int i = 0; i < acceptedKeys.length;i++){
			if(key == acceptedKeys[i]){
				addKey(key);
				break;
			}
		}
		e.consume();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = (int) e.getKeyChar();
		for(int i = 0; i < keys.length;i++){
			if(key == keys[i]){
				removeKey(key);
				break;
			}
		}
		e.consume();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
		
	}
	private void addKey(int key){
		int[] tempKeys = new int[keys.length+1];
		for(int i = 0; i < keys.length;i++){
			tempKeys[i] = keys[i];
		}
		tempKeys[tempKeys.length] = key;
		keys = tempKeys;
	}
	private void removeKey(int key){
		int offset = 0;
		int[] tempKeys = new int[keys.length-1];
		for(int i = 0; i < keys.length; i++){
			if(keys[i] == key){
				offset = 1;
			}
			else{
				tempKeys[i-offset] = keys[i];
			}
		}
		keys = tempKeys;
	}
	
}
