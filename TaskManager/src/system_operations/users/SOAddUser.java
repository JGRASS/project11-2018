package system_operations.users;

import java.util.ArrayList;

import classes.user.User;

public class SOAddUser {

	public static ArrayList<User> execute(ArrayList<User> users, User user){
		if(!users.contains(user)) {
			users.add(user);
		}
		return users;
	}
	
}
