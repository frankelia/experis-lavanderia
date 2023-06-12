package org.lessons.java.lavanderia;

import org.lessons.java.lavanderia.exceptions.LavanderiaException;
import org.lessons.java.lavanderia.exceptions.MachineActivationException;

public class WashingMachine extends Machine {

	private Tank tankDetergent;
	
	private Tank tankSoftener;
	
//	public WashingMachine(int id, List<WashingMachineProgram> programs) {
//		super(id);
//		this.tankDetergent = new Tank(1000);
//		this.tankSoftener = new Tank(500);
//		this.programs = programs;
//	}
	
	public WashingMachine(int id) {
		super(id);
		this.tankDetergent = new Tank(1000);
		this.tankSoftener = new Tank(500);
		
		this.programs.add(new WashingMachineProgram(1, "Rinfrescante", 20, 5, 25, 20));
		this.programs.add(new WashingMachineProgram(2, "Rinnovante", 40, 10, 50, 40));
		this.programs.add(new WashingMachineProgram(3, "Sgrassante", 60, 15, 100, 60));
	}
	
	public Tank getTankDetergent() {
		return tankDetergent;
	}
	
	public Tank getTankSoftener() {
		return tankSoftener;
	}
	
	@Override
	public String toString() {
		return id + " " + open + " " + coins  + " " + tankSoftener + " " + tankDetergent;
	}
	
	public String[] toStringArray() {
		return new String[] {
			String.valueOf(id),
			"Lavatrice",
			String.valueOf(coins),
			String.valueOf(open),
			String.valueOf(isActive()),
			selectedProgram != null ? String.valueOf(selectedProgram) : " - ",
			"TODO",
			String.valueOf(tankDetergent.getLevel()),
			String.valueOf(tankSoftener.getLevel())
		};
	}

	@Override
	public void activate() throws LavanderiaException {
		WashingMachineProgram machineProgram = (WashingMachineProgram)programs.get(selectedProgram - 1);
		
		if (open)
			throw new MachineActivationException("ERRORE: La macchina deve essere chiusa");
		
		if (selectedProgram == null)
			throw new MachineActivationException("ERRORE: Devi selezionare un programma valido");
		
		if (coins < machineProgram.getCoins())
			throw new MachineActivationException("ERRORE: I gettoni non sono sufficienti (richiesti "
				+ machineProgram.getCoins() + ", presenti " + coins + ")");
		
		if (tankDetergent.getLevel() < machineProgram.getCostDetergent())
			throw new MachineActivationException("ERRORE: Il detersivo non è sufficiente (richiesto "
					+ machineProgram.getCostDetergent() + ", presente " + tankDetergent.getLevel() + ")");
		
		if (tankSoftener.getLevel() < machineProgram.getCostSoftener())
			throw new MachineActivationException("ERRORE: L'ammorbidente non è sufficiente (richiesto "
					+ machineProgram.getCostSoftener() + ", presente " + tankSoftener.getLevel() + ")");
		
		this.coins -= machineProgram.getCoins();
		
		this.tankDetergent.setLevel(this.tankDetergent.getLevel() - machineProgram.getCostDetergent());
		this.tankSoftener.setLevel(this.tankSoftener.getLevel() - machineProgram.getCostSoftener());
		
		this.active = true;
	}

	@Override
	public void deactivate() {
		this.active = false;
	}


}
