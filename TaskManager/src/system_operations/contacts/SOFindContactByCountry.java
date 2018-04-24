package system_operations.contacts;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOFindContactByCountry {

	/**
	 * Pronalazi kontakte po nazivu drzave
	 * @param country ime drzave
	 * @param contacts lista kontakata
	 * @return found kontakte koji su iz zadate drzave
	 */
	public static ArrayList<CoWorker> execute(String country, ArrayList<CoWorker> contacts) {
		ArrayList<CoWorker> found = new ArrayList<CoWorker>();

		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getCountry().contains(country))
				found.add(contacts.get(i));
		}

		return found;
	}

}
