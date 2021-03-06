package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOAddContact {

	/**
	 * Dodaje kontakt u listu kontakata i sortira azuriranu listu kontakata
	 * @param contacts lista kontakata
	 * @param coWorker novi kontakt
	 * @throws java.lang.RuntimeException ako je vrednost unetog saradnika null
	 */
	public static void execute(ArrayList<CoWorker> contacts, CoWorker coWorker){
		if(coWorker == null)
			throw new RuntimeException("CoWorker is null");
		if(!contacts.contains(coWorker)) {
			contacts.add(coWorker);
			SOSortContacts.execute(contacts);
		}
	}
	
}
