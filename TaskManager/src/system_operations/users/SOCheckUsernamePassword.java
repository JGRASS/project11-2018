package system_operations.users;

import java.util.ArrayList;

import classes.user.User;

public class SOCheckUsernamePassword {

	public static User execute(ArrayList<User> users, User user) {
		if(users.contains(user))
			for(int i = 0; i<users.size(); i++)
				if(users.get(i).equals(user))
					return users.get(i);			
		return null;
	}
	
}
