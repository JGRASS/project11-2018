package system_operations.users;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import classes.user.User;

public class SOLoadUsers {
	
	/**
	 * Ucitavanje liste zaposlenih iz datoteke
	 * @param file datoteka sa podacima
	 * @throws java.lang.RuntimeException ukoliko je neuspesno ucitavanje iz datoteke
	 * @return listu zaposlenih
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<User> execute(String file){
		
		try(ObjectInputStream in = 
				new ObjectInputStream(
						new FileInputStream(file))){
			return (ArrayList<User>) in.readObject();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
}
