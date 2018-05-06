package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOAddContact {

	/**
	 * Dodaje kontakt u listu kontakata
	 * @param contacts lista kontakata
	 * @param coWorker novi kontakt
	 */
	public static void execute(ArrayList<CoWorker> contacts, CoWorker coWorker){
		if(!contacts.contains(coWorker)) {
			contacts.add(coWorker);
			SOSortContacts.execute(contacts);
		}
	}
	
}
