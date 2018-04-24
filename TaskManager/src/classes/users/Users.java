package classes.users;

import java.util.ArrayList;
import java.util.LinkedList;

import classes.user.User;
import interfaces.UsersInterface;
import system_operations.users.SOLoadUsers;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User checkUsernamePassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
