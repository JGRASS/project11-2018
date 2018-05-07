package system_operations.users;

import java.util.ArrayList;

import classes.user.User;

public class SOAddUser {

	/**
	 * Dodavanje novog zaposlenog u listu
	 * @param users lista zaposlenog
	 * @param user novi zaposleni
	 * @throws java.lang.RuntimeException ako je vrednost unetog saradnika null
	 */
	public static void execute(ArrayList<User> users, User user){
		if(user==null)
			throw new RuntimeException("User is null");
		if(!users.contains(user))
			users.add(user);
	}
	
}
