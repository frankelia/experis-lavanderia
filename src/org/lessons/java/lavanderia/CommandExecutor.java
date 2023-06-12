package org.lessons.java.lavanderia;

import org.lessons.java.lavanderia.exceptions.ExitException;
import org.lessons.java.lavanderia.exceptions.InvalidCommandException;
import org.lessons.java.lavanderia.exceptions.LavanderiaException;

public class CommandExecutor {
	private Lavanderia lavanderia;
	
	public CommandExecutor(Lavanderia lavanderia) {
		this.lavanderia = lavanderia;
	}

	public String runCommand(String command) throws LavanderiaException {
		String[] tokens = command.split(" ");
		// "gettoni 12 5" => ["gettoni", "12", "5"]
		
		Commands cmd;
		try {
			cmd = Commands.valueOf(tokens[0].toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandException("ERRORE: Comando non riconosciuto: " + tokens[0]);
		}
		
		int id = 0;
		if (tokens.length >= 2) {
			try {
				id = Integer.parseInt(tokens[1]);
				// TODO: Controllare anche che l'id sia effettivamente esistente
			} catch (NumberFormatException e) {
				throw new InvalidCommandException("ERRORE: Il secondo parametro deve essere un intero positivo");
			}
		} 
		
		Integer additionalParam = null;
		boolean hasThreeParams = 
				cmd == Commands.GETTONI || cmd == Commands.AMMORBIDENTE
				|| cmd == Commands.DETERSIVO || cmd == Commands.PROGRAMMA;
		
		if (tokens.length > 2) {
			try {
				additionalParam = Integer.parseInt(tokens[2]);
				
				if (!hasThreeParams)
					throw new InvalidCommandException("ERRORE: Il comando " + cmd + " ha solo 2 parametri");
			} catch (NumberFormatException e) {
				throw new InvalidCommandException("ERRORE: Il terzo parametro deve essere un intero positivo");
			}
		} else {
			if (hasThreeParams)
				throw new InvalidCommandException("ERRORE: Il comando " + cmd + " deve ricevere 3 parametri");
		}
		
		if (additionalParam != null && additionalParam <= 0) {
			throw new InvalidCommandException("ERRORE: Il comando " + cmd + " ha come terzo parametro un intero positivo");
		}
		
		Machine machine = null;
		if (id != 0)
			machine = lavanderia.getMachineById(id);
		
		String output;
		
		// detersivo e ammorbidente > capacità
		// all'avvio: gettoni sufficienti, detersivo e ammorbidente sufficienti
		switch (cmd) {
			case APRI:
				machine.setOpen(true);
				output = "Macchina " + id + " aperta";
				break;
			case CHIUDI:
				machine.setOpen(false);
				output = "Macchina " + id + " chiusa";
				break;
			case GETTONI:
				machine.addCoins(additionalParam);
				output = additionalParam + " gettoni aggiunti alla macchina " + id;
				break;
			case LISTA:
				output = lavanderia.programsTable(id);
				break;
			case PROGRAMMA:
				machine.setSelectedProgram(additionalParam);
				output = "Programma " + additionalParam + " impostato sulla macchina " + id;
				break;
			case AVVIA:
				machine.activate();
				output = "Macchina " + id + " avviata";
				break;
			case FERMA:
				output = "Macchina " + id + " fermata";
				machine.deactivate();
				break;
			case DETERSIVO:
				if (machine instanceof WashingMachine) {
					WashingMachine m = (WashingMachine)machine;
					m.getTankDetergent().setLevel(m.getTankDetergent().getLevel() + additionalParam);
					output = additionalParam + "ml di detersivo aggiunti alla macchina " + id;
				} else {
					throw new InvalidCommandException("ERRORE: La macchina " + id + " non è una lavatrice");
				}
				break;
			case AMMORBIDENTE:
				if (machine instanceof WashingMachine) {
					WashingMachine m = (WashingMachine)machine;
					m.getTankSoftener().setLevel(m.getTankSoftener().getLevel() + additionalParam);
					output = additionalParam + "ml di ammorbidente aggiunti alla macchina " + id;
				} else {
					throw new InvalidCommandException("ERRORE: La macchina " + id + " non è una lavatrice");
				}
				break;
			case ESCI:
				throw new ExitException("Uscita");
			default:
				output = "N/A";
				break;
		}
		
		return output;
	}
}
