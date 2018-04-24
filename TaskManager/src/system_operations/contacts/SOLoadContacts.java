package system_operations.contacts;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOLoadContacts {
	
	/**
	 * Ucitavanje kontakata iz fajla u listu
	 * @param file datoteka u kojoj se nalaze kontakti
	 * @throws java.lang.RuntimeException ukoliko je neuspesno ucitavanje iz datoteke
	 * @return listu kontakata
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<CoWorker> execute(String file){
		try(ObjectInputStream in = 
				new ObjectInputStream(
						new FileInputStream(file))){
			return (ArrayList<CoWorker>) in.readObject();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
