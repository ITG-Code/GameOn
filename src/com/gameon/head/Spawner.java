package com.gameon.head;

import java.util.LinkedList;

import com.gameon.hitboxers.Enemy;

public class Spawner {
	private int spawnRate;

	public Spawner() {
		
	}

	public void setSpawnRate(int r){
		spawnRate = r;
	}

	public Enemy tick(LinkedList<Enemy> e){
		LinkedList<Integer> s = new LinkedList<Integer>();
		for(int i = 0; i < e.size(); i++){
		}
		return null;
	}
}
