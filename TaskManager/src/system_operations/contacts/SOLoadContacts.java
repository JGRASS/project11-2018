package system_operations.contacts;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import classes.coworker.CoWorker;

public class SOLoadContacts {
	
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
