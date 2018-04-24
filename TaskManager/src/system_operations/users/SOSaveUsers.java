package system_operations.users;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import classes.user.User;

public class SOSaveUsers {

	/**
	 * Cuvanje liste zaposlenih u datoteci
	 * @param file datoteka za cuvanje podataka
	 * @param users lista zaposlenih
	 * @throws java.lang.RuntimeException ukoliko je neuspesno cuvanje u datoteku
	 */
	public static void execute(String file, ArrayList<User> users) {
		try(ObjectOutputStream out = 
				new ObjectOutputStream(
						new FileOutputStream(file))) {
			out.writeObject(users);
		}catch (Exception e) {
			new RuntimeException(e.getMessage());
		}
	}
	
	
}
