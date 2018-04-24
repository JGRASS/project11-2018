package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOAddContact {

	public static ArrayList<CoWorker> execute(ArrayList<CoWorker> contacts, CoWorker coWorker){
		if(!contacts.contains(coWorker)) {
			contacts.add(coWorker);
			return SOSortContacts.execute(contacts);
		}
		return contacts;
	}
	
}
