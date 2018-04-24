package classes.users;

import java.util.ArrayList;

import classes.user.User;
import interfaces.UsersInterface;
import system_operations.users.SOAddUser;
import system_operations.users.SOCheckUsernamePassword;
import system_operations.users.SOLoadUsers;
import system_operations.users.SOSaveUsers;

public class Users implements UsersInterface{
	
	private ArrayList<User> users = new ArrayList<User>();


	public ArrayList<User> getUsers() {
		return users;
	}

	@Override
	public void loadUsers(String file) {
		users = SOLoadUsers.execute(file);
		
	}

	@Override
	public void saveUsers(String file) {
		SOSaveUsers.execute(file, users);	
	}

	@Override
	public void addUser(User user) {
		users = SOAddUser.execute(users, user);
		
	}

	@Override
	public User checkUsernamePassword(User user) {
		return SOCheckUsernamePassword.execute(users, user);
	}
	
	

}
