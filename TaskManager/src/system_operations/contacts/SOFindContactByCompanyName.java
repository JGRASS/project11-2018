package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOFindContactByCompanyName {

	public static ArrayList<CoWorker> execute(ArrayList<CoWorker> contacts, String companyName){
		ArrayList<CoWorker> found = new ArrayList<CoWorker>();
		
		for(int i = 0 ; i<contacts.size(); i++) {
			if(contacts.get(i).getCompanyName().contains(companyName))
				found.add(contacts.get(i));
		}
		
		return found;
	}
	
}
