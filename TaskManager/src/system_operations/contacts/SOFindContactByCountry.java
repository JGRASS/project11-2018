package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOFindContactByCountry {

	public static ArrayList<CoWorker> execute(String country, ArrayList<CoWorker> contacts) {
		ArrayList<CoWorker> found = new ArrayList<CoWorker>();

		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getCountry().contains(country))
				found.add(contacts.get(i));
		}

		return found;
	}

}
