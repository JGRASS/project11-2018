package classes.users;

import java.util.ArrayList;
import java.util.LinkedList;

import classes.user.User;
import interfaces.UsersInterface;
import system_operations.users.SOAddUser;
import system_operations.users.SOCheckUsernamePassword;
import system_operations.users.SOLoadUsers;
import system_operations.users.SOSaveUsers;

/**
 * Klasa koja predstavlja zaposlene
 * @author Teodora Acimov
 *
 */
public class Users implements UsersInterface{
	
	/**
	 * Lista zaposlenih
	 */
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * Vraca listu zaposlenih
	 * @return users lista zaposlenih
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * Ucitavanje liste zaposlenih
	 */
	@Override
	public void loadUsers(String file) {
		users = SOLoadUsers.execute(file);
		
	}

	/**
	 * Cuvanje liste zaposlenih u datoteku
	 */
	@Override
	public void saveUsers(String file) {
		SOSaveUsers.execute(file, users);	
	}

	/**
	 * Dodavanje novog zaposlenog u listu
	 */
	@Override
	public void addUser(User user) {
		users = SOAddUser.execute(users, user);
		
	}

	/**
	 * Provera username-a i lozinke
	 */
	@Override
	public User checkUsernamePassword(User user) {
		return SOCheckUsernamePassword.execute(users, user);
	}
	
	

}
