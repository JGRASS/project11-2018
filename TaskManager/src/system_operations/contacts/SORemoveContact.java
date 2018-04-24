package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SORemoveContact {

	/**
	 * Brisanje kontakta iz liste kontakta
	 * @param contacts lista kontakata
	 * @param coWorker kontakt koji se brise
	 * @return contacts azurirana lista kontakata
	 */
	public static ArrayList<CoWorker> execute(ArrayList<CoWorker> contacts, CoWorker coWorker){
		if(contacts.contains(coWorker)) 
			contacts.remove(coWorker);
		return contacts;
	}
	
}
