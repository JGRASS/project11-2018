package system_operations.contacts;

import java.util.ArrayList;
import java.util.Collections;

import classes.coworker.CoWorker;

public class SOSortContacts {
	
	public static ArrayList<CoWorker> execute(ArrayList<CoWorker> contacts){
		Collections.sort(contacts);
		return contacts;
	}
	
}
