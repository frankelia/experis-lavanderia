package org.lessons.java.lavanderia;

public class Traccia {
	/*
	Realizzare un programma console in Java per la verifica remota del funzionamento delle lavatrici
	e delle asciugatrici presenti in una lavanderia self-service.
	
	== Descrizione generale ==
	La lavanderia possiede 3 lavatrici e 2 asciugatrici. Le lavatrici hanno due serbatoi integrati, 
	uno di detersivo e uno di ammorbidente. Il serbatoio di detersivo ha una capacità di 1000ml mentre
	quello dell’ammorbidente di 500ml.
	
	== Programmi delle lavatrici ==
	   Numero Nome         Durata (minuti) Gettoni Consumo ammorbidente (ml) Consumo detersivo (ml)     
	   1      Rinfrescante 20              5       20                        25   
	   2      Rinnovante   40              10      40                        50   
	   3      Sgrassante   60              15      60                        100   

	== Programmi delle asciugatrici ==
	   Numero Nome         Durata (minuti) Gettoni     
	   1      Rapido       20              2   
	   2      Intenso      60              4   
	   
	L’utente può agire tramite il programma per effettuare le seguenti verifiche:
	 - Aprire lo sportello
	 - Chiudere lo sportello
	 - Inserire i gettoni
	 - Chiedere la lista dei programmi
	 - Selezionare un programma
	 - Avviare il programma selezionato
	 - Fermare il programma in esecuzione
	 - Ricaricare detersivo e ammorbidente
	 
	Se una di queste operazioni non è logicamente possibile, il programma dovrà mandare un messaggio 
	all’utente per evidenziare la problematica.
	
	== Linee guida e vincoli ==
	Per la realizzazione si implementi il codice utilizzando il paradigma ad oggetti e identificando, 
	se necessario, classi astratte ed eredità. Non è necessario l’utilizzo di interfacce.
	
	Per l’interazione con l’utente si implementi il seguente comportamento nel Program.java:
	Finché l’utente non decide di uscire:
	 - Stampa lo stato delle macchine in formato tabellare
	 - Mostra un messaggio informativo dell’ultima operazione effettuata. Questo messaggio può contenere sia gli errori che le operazioni andate a buon fine
	 - Mostra la lista dei comandi
	 - Attende l’inserimento del comando dell’utente
	
	== Lista comandi ==
	Formato della stringa del comando : comando <numero_macchina> <parametro aggiuntivo>
	   Comando      Descrizione         															Parametro aggiuntivo     
	   apri         apre lo sportello   															-   
	   chiudi       chiude lo sportello 															-   
	   gettoni      inserisce il numero di gettoni nella macchina specificata 						numero di gettoni positivo e maggiore di 0   
	   lista 		fornisce la lista dei programmi 												-   
	   programma 	seleziona il programma specificato sulla macchina indicata 						numero del programma
	   avvia 		avvia il lavaggio o l’asciugatura sulla macchina specificata 
	   ferma 		ferma il lavaggio o l’asciugatura sulla macchina specificata 
	   detersivo 	ricarica il detersivo sulla macchina specificata 								quantità di detersivo   
	   ammorbidente	ricarica l'ammorbidente sulla macchina specificata 								quantità di ammorbidente   
	
	Aggiungere anche un comando Esci per terminare il ciclo di esecuzione e uscire dal programma.
	
	All’avvio dell’applicazione si consideri:
	 - uno stato casuale per l’apertura o la chiusura dello sportello
	 - uno stato casuale per il numero di gettoni inseriti tra 0 e 15 gettoni
	 - uno stato casuale per il detersivo e l’ammorbidente e del detersivo tra 0 e il massimo consentito per lo specifico serbatoio
	 
	Per la visualizzazione tabellare si utilizzi il pacchetto java-ascii-table:
	https://code.google.com/archive/p/java-ascii-table/downloads
	NB. Il jar è già presente nel codice sorgente, aggiungerlo al build path tramite eclipse.
	
	BONUS
	Per rendere il sistema un pò più realistico si gestisca una simulazione del tempo che passa con il seguente comportamento.
	 - All’avvio della macchina si registra l’orario di avvio
	 - Ad ogni ciclo, richiamare una funzione lavanderia.Simulazione() che per ogni macchina in funzione calcoli il tempo rimanente di funzionamento
	 - Quando la macchina termina il tempo semplicemente non è più in funzione
	*/
}
