package org.lessons.java.lavanderia;

public class DryingMachineProgram extends MachineProgram {

	public DryingMachineProgram(int id, String name, int duration, int coins) {
		super(id, name, duration, coins);
	}

	
	public String[] toStringArray() {
		return new String[] {
			String.valueOf(id),
			name,
			String.valueOf(duration),
			String.valueOf(coins)
		};
	}
}
