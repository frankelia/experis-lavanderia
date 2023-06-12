package org.lessons.java.lavanderia;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.lavanderia.exceptions.InvalidCommandException;

import com.bethecoder.ascii_table.ASCIITable;

public class Lavanderia {
	private final static String[] HEADER_MACHINES = new String[] {
		"Numero", "Tipo", "Gettoni", "Aperta", "In Funzione", "Programma", "Tempo rimanente", "Detersivo", "Ammorbidente"
	};
	
	private final static String[] HEADER_WASHING_PROGRAMS = new String[] {
		"Numero", "Nome", "Durata", "Gettoni", "Consumo detersivo", "Consumo ammorbidente"
	};
	
	private final static String[] HEADER_DRYING_PROGRAMS = new String[] {
		"Numero", "Nome", "Durata", "Gettoni"
	};
	
	
	private List<Machine> machines = new ArrayList<>();
	
	public Lavanderia(int numWashingMachines, int numDryingMachines) {
		for (int i = 0; i < numWashingMachines; i++) {
			machines.add(new WashingMachine(i + 1));
		}
		
		for (int i = 0; i < numDryingMachines; i++) {
			machines.add(new DryingMachine(numWashingMachines + i + 1));
		}
	}
	
	public Machine getMachineById(int id) throws InvalidCommandException {
		if (id > machines.size())
			throw new InvalidCommandException("ERRORE: La macchina " + id + " è inesistente");

		return machines.get(id - 1);
	}
	
	public List<Machine> getMachines() {
		return machines;
	}
	
	public String statusTable() {
		String[][] tabella = new String[machines.size()][];
		
		for (int i = 0; i < machines.size(); i++) {
			tabella[i] = machines.get(i).toStringArray();
		}
		
		return ASCIITable.getInstance().getTable(HEADER_MACHINES, tabella);
	}
	
	public String programsTable(int id) throws InvalidCommandException {
		Machine machine = getMachineById(id);
		String[][] programsTable = machine.programsToStringArray();
		
		if (machine instanceof WashingMachine)
			return ASCIITable.getInstance().getTable(HEADER_WASHING_PROGRAMS, programsTable);
		else if (machine instanceof DryingMachine)
			return ASCIITable.getInstance().getTable(HEADER_DRYING_PROGRAMS, programsTable);
		else
			throw new RuntimeException("ERRORE: Macchina " + machine.getClass().getSimpleName() + " non supportata");

	}
}
