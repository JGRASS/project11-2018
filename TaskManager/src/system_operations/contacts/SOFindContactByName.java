package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOFindContactByName {
	
	public static ArrayList<CoWorker> execute(ArrayList<CoWorker> contacts, String name){
		ArrayList<CoWorker> found = new ArrayList<CoWorker>();
		
		for(int i = 0 ; i<contacts.size(); i++) {
			if(contacts.get(i).getName().contains(name))
				found.add(contacts.get(i));
		}
		
		return found;
	}
	
}
