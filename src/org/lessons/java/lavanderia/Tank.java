package org.lessons.java.lavanderia;

import org.lessons.java.lavanderia.exceptions.InvalidCommandException;

public class Tank {
	private int capacity;
	
	private int level;
	
	public Tank(int capacity) {
		this.level = 0;
		this.capacity = capacity;
	}
	
	public Tank(int level, int capacity) {
		this.level = level;
		this.capacity = capacity;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setLevel(int level) throws InvalidCommandException {
		if (level > capacity || level < 0)
			throw new InvalidCommandException("ERRORE: Livello " + level + " maggiore della capacità " + capacity);
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "[" + level + "/" + capacity + "]";
	}
}
