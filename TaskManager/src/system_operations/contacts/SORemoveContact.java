package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SORemoveContact {

	/**
	 * Brisanje kontakta iz liste kontakta
	 * @param contacts lista kontakata
	 * @param coWorker kontakt koji se brise
	 * @throws java.lang.RuntimeException ako je vrednost unetog saradnika null
	 */
	public static void execute(ArrayList<CoWorker> contacts, CoWorker coWorker){
		if(contacts.contains(coWorker)) 
			contacts.remove(coWorker);
	}
	
}
