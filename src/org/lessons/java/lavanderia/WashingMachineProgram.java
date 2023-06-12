package org.lessons.java.lavanderia;

public class WashingMachineProgram extends MachineProgram {

	private int costDetergent;
	
	private int costSoftener;
	
	public WashingMachineProgram(int id, String name, int duration, int coins, int costDetergent, int costSoftener) {
		super(id, name, duration, coins);
		this.costDetergent = costDetergent;
		this.costSoftener = costSoftener;
	}
	
	public int getCostDetergent() {
		return costDetergent;
	}
	
	public int getCostSoftener() {
		return costSoftener;
	}

	public String[] toStringArray() {
		return new String[] {
			String.valueOf(id),
			name,
			String.valueOf(duration),
			String.valueOf(coins),
			String.valueOf(costDetergent),
			String.valueOf(costSoftener)
		};
	}
}
