package org.lessons.java.lavanderia;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.lavanderia.exceptions.InvalidCommandException;
import org.lessons.java.lavanderia.exceptions.LavanderiaException;

public abstract class Machine {
	protected int id;
	
	protected boolean open = false;
	
	protected int coins = 0;
	
	protected List<MachineProgram> programs = new ArrayList<>();
	
	protected Integer selectedProgram;
	
	protected boolean active;
		
	public abstract String[] toStringArray();
	
	public Machine(int id) {
		this.id = id;
	}

	public Integer getSelectedProgram() {
		return selectedProgram;
	}
	
	public void setSelectedProgram(Integer selectedProgram) throws InvalidCommandException {
		if (selectedProgram > programs.size() || selectedProgram < 0)
			throw new InvalidCommandException("ERRORE: Il programma " + selectedProgram + " non è valido");
		this.selectedProgram = selectedProgram;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public abstract void activate() throws LavanderiaException;	
	public abstract void deactivate();
	
	public int getId() {
		return id;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public void addCoins(int coins) {
		this.coins += coins;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}

	public String[][] programsToStringArray() {
		String[][] table = new String[programs.size()][];
		
		for (int i = 0; i < programs.size(); i++) {
			table[i] = programs.get(i).toStringArray();
		}
		
		return table;
	}
	
}
