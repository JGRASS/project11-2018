package system_operations.contacts;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOSaveContacts {
	
	/**
	 * Upisivanje liste kontakata u fajl
	 * @param file fajl u kojem cuvamo kontakte
	 * @param contacts lista kontakata
	 * @throws java.lang.RuntimeException ukoliko je neuspesno upisivanje u fajl
	 */
	public static void execute(String file, ArrayList<CoWorker> contacts) {
		try(ObjectOutputStream out = 
				new ObjectOutputStream(
						new FileOutputStream(file))){
			out.writeObject(contacts);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
