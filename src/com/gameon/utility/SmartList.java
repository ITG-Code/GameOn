package com.gameon.utility;

import java.util.LinkedList;

public class SmartList<E> extends LinkedList{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addSmart(E e){
		for(int i = 0; i < this.size(); i++){
			if(this.get(i).equals(null)){
				this.add(i, e);
			}
		}
	}
}
