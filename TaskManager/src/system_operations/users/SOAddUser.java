package system_operations.users;

import java.util.ArrayList;

import classes.user.User;

public class SOAddUser {

	/**
	 * Dodavanje novog zaposlenog u listu
	 * @param users lista zaposlenog
	 * @param user novi zaposleni
	 * @return users azuriranu listu zaposlenih
	 */
	public static ArrayList<User> execute(ArrayList<User> users, User user){
		if(!users.contains(user)) {
			users.add(user);
		}
		return users;
	}
	
}
