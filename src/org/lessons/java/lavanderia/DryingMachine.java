package org.lessons.java.lavanderia;

import org.lessons.java.lavanderia.exceptions.MachineActivationException;

public class DryingMachine extends Machine {

	public DryingMachine(int id) {
		super(id);
		this.programs.add(new DryingMachineProgram(1, "Rapido", 20, 2));
		this.programs.add(new DryingMachineProgram(2, "Intenso", 60, 4));
	}
	
	@Override
	public String toString() {
		return id + " " + open + " " + coins  + " ";
	}
	
	public String[] toStringArray() {
		return new String[] {
			String.valueOf(id),
			"Asciugatrice",
			String.valueOf(coins),
			String.valueOf(open),
			String.valueOf(isActive()),
			selectedProgram != null ? String.valueOf(selectedProgram) : " - ",
			"TODO",
			"N/A",
			"N/A"
		};
	}

	@Override
	public void activate() throws MachineActivationException {
		if (open)
			throw new MachineActivationException("ERRORE: La macchina deve essere chiusa");
		
		if (selectedProgram == null)
			throw new MachineActivationException("ERRORE: Devi selezionare un programma valido");
		
		MachineProgram machineProgram = programs.get(selectedProgram - 1);
		if (coins < machineProgram.getCoins())
			throw new MachineActivationException("ERRORE: I gettoni non sono sufficienti (richiesti "
				+ machineProgram.getCoins() + ", presenti " + coins + ")");
		
		this.coins -= machineProgram.getCoins();
		this.active = true;
	}

	@Override
	public void deactivate() {
		this.active = false;
	}

}
