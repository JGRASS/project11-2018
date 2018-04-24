package system_operations.contacts;

import java.util.ArrayList;
import java.util.Collections;

import classes.coworker.CoWorker;

public class SOSortContacts {
	
	/**
	 * Sortira kontakte prema nazivu kompanije
	 * @param contacts lista kontakata
	 * @return contacts sortiranu listu kontakata
	 */
	public static ArrayList<CoWorker> execute(ArrayList<CoWorker> contacts){
		Collections.sort(contacts);
		return contacts;
	}
	
}
