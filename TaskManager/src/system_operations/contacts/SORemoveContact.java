package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SORemoveContact {

	/**
	 * Brisanje kontakta iz liste kontakta
	 * @param contacts lista kontakata
	 * @param coWorker kontakt koji se brise
	 */
	public static void execute(ArrayList<CoWorker> contacts, CoWorker coWorker){
		if(coWorker.equals(null))
			throw new RuntimeException("CoWorker is null");
		if(contacts.contains(coWorker)) 
			contacts.remove(coWorker);
	}
	
}
