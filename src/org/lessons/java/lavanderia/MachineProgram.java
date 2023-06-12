package org.lessons.java.lavanderia;

public abstract class MachineProgram {
	protected int id;
	
	protected String name;
	
	protected int duration;
	
	protected int coins;

	public abstract String[] toStringArray();
	
	public MachineProgram(int id, String name, int duration, int coins) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.coins = coins;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public int getCoins() {
		return coins;
	}
	
}
