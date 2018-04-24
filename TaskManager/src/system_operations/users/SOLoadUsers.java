package system_operations.users;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import classes.user.User;

public class SOLoadUsers {
	
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
