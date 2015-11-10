package com.gameon.head;

import java.util.LinkedList;
import java.util.Random;

import com.gameon.hitboxers.Enemy;
import com.gameon.utility.Spawn;

public class Spawner {
	private int spawnRate;
	private Random r;
	private static int noSpawn;
	private long lastSpawn;
	public Spawner() {
		r = new Random();

	}

	public void setSpawnRate(int rate) {
		spawnRate = rate;
	}

	public Spawn tick(LinkedList<Enemy> e) {
		boolean[] filled = { false, false, false };
		byte filledSlots = 0;
		for (int i = 0; i < e.size(); i++) {
			if (e.get(i).getY() < 200) {
				if (e.get(i).getLane() == -1 && e.get(i).getY() > noSpawn) {
					filled[0] = true;
					filledSlots++;
				} else if (e.get(i).getLane() == 1 && e.get(i).getY() > noSpawn) {
					filled[1] = true;
					filledSlots++;
				} else if (e.get(i).getLane() == 3 && e.get(i).getY() > noSpawn) {
					filled[2] = true;
					filledSlots++;
				}

			}
		}
		int et = (int) (Math.random() * 2);
		int lane = (int) (Math.random() * filledSlots);

		return new Spawn(lane, et);
	}

}
