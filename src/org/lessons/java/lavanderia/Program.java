package org.lessons.java.lavanderia;

import java.util.Scanner;

import org.lessons.java.lavanderia.exceptions.ExitException;
import org.lessons.java.lavanderia.exceptions.LavanderiaException;

public class Program {
	
	private Lavanderia lavanderia;
	
	private CommandExecutor exec;
	
	private String lastMessage = "Nessuna operazione ancora effettuata.";
	
	public void run() {
		init();

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println(" == STATO LAVANDERIA ==");
			System.out.println(lavanderia.statusTable());
			
			System.out.println(" == ULTIMA OPERAZIONE == ");
			System.out.println(lastMessage + "\n");
			
			System.out.println(" == UTILIZZO ==");
			System.out.println(usage());
			
			System.out.print("\nInserisci un comando: ");
			
			String command = scanner.nextLine();
			try {
				lastMessage = exec.runCommand(command);
			} catch (ExitException e) {
				break;
			} catch (LavanderiaException e) {
				lastMessage = e.getMessage();
			}
			
		}
		
		scanner.close();
	}
	
	public void init() {
		lavanderia = new Lavanderia(3, 2);
		exec = new CommandExecutor(lavanderia);
	}
	
	public String usage() {
		return "Comando      Descrizione         											Parametro aggiuntivo     \n"
			+ "apri         apre lo sportello   													-   \n"
			+ "chiudi       chiude lo sportello 													-   \n"
			+ "gettoni      inserisce il numero di gettoni nella macchina specificata 							numero di gettoni positivo e maggiore di 0   \n"
			+ "lista 	     fornisce la lista dei programmi 										-   \n"
			+ "programma    seleziona il programma specificato sulla macchina indicata 						numero del programma\n"
			+ "avvia 	     avvia il lavaggio o l’asciugatura sulla macchina specificata \n"
			+ "ferma 	     ferma il lavaggio o l’asciugatura sulla macchina specificata \n"
			+ "detersivo    ricarica il detersivo sulla macchina specificata quantità di detersivo   \n"
			+ "ammorbidente ricarica l'ammorbidente sulla macchina specificata quantità di ammorbidente";
		   
	}
}
