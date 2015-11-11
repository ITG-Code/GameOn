package com.gameon.utility;

public class Spawn {
	private int lane;
	private int type;
	public Spawn(int lane, int type){
		this.lane = lane;
		this.type = type;
	}
	public int getLane() {
		return lane;
	}
	public int getType() {
		return type;
	}
}
