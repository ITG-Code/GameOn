package com.gameon.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardInput extends KeyAdapter{
	private int[] keys;
	private long[] keyTime;
	public int[] getInputs(){
		return keys;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = (int) e.getKeyChar();
		addKey(key);
		e.consume();
	}
	@Override
	public void keyReleased(KeyEvent e) {
	//	System.out.println(keys.length);
		int key = (int) e.getKeyChar();
	    //System.out.println(key);
		removeKey(key);
		e.consume();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
		
	}
	private void addKey(int key){
		if(keys == null){
			keys = new int[1];
			keys[0] = key;
			keyTime = new long[1];
			keyTime[0] = System.nanoTime();
		}
		else{
			boolean exists = false;
			for(int i = 0; i < keys.length;i++){
				if(keys[i] == key){
					exists = true;
				}
			}
			if(!exists){
				long[] tempTime = new long[keys.length+1];
				int[] tempKeys = new int[keys.length+1];
				for(int i = 0; i < keys.length;i++){
					tempKeys[i] = keys[i];
					tempTime[i] = keyTime[i];
				}
				tempTime[tempKeys.length-1] = System.nanoTime();
				tempKeys[tempKeys.length-1] = key;
				
				keys = tempKeys;
				keyTime = tempTime;
			}
			
		}
		
	
	}
	private void removeKey(int key){
		/*int[] tempKeys = new int[keys.length-1];
		long[] tempTime = new long[keys.length-1];
		for(int i = 0; i < keys.length; i++){
			//If the the key matches the key in the array and 1 game tick in time has passed, remove the key
			if(key == keys[i] && System.nanoTime() >= keyTime[i] + 1000000000.0 / 60.0){
				int keyFoundOffset = 0;
				for(int j = 0; j < keys.length;j++){
					if(i != j){
						tempKeys[i-keyFoundOffset] = keys[i];
						tempTime[i-keyFoundOffset] = keyTime[i];
					}
					else{
						keyFoundOffset = 1;
					}
				}
			}
		}
		keyTime = tempTime;
		keys = tempKeys;*/
		int[] tempKeys = new int[keys.length-1];
		int offset = 0;
		for(int i = 0; i < keys.length;i++){
			if(key == keys[i]){
				offset = 1;
			}
			else{
				tempKeys[i-offset] = keys[i];
				
			}
		}
		keys = tempKeys;
	}
	
}
