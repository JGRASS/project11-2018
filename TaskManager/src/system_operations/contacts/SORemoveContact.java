package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SORemoveContact {

	public static ArrayList<CoWorker> execute(ArrayList<CoWorker> contacts, CoWorker coWorker){
		if(contacts.contains(coWorker)) 
			contacts.remove(coWorker);
		return contacts;
	}
	
}
