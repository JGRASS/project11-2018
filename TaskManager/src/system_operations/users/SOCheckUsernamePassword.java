package system_operations.users;

import java.util.ArrayList;

import classes.user.User;

public class SOCheckUsernamePassword {

	/**
	 * Proverava username i password i vraca podatke o zaposlenom
	 * @param users lista zaposlenih
	 * @param user sa ukucanim passwordima i username 
	 * @throws java.lang.RuntimeException ako je uneti user null vrednost
	 * @return odgovarajuceg zaposlenog ili null ukoliko parametri nisu dobro uneti
	 */
	public static User execute(ArrayList<User> users, User user) {
		if(user==null)
			throw new RuntimeException("User je null");
		if(users.contains(user))
			for(int i = 0; i<users.size(); i++)
				if(users.get(i).equals(user))
					return users.get(i);			
		return null;
	}
	
}
