package classes.user;

import java.util.ArrayList;

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
	 * @param file datoteka sa listom zaposlenih
	 */
	@Override
	public void loadUsers(String file) {
		users = SOLoadUsers.execute(file);
	}

	/**
	 * Cuvanje liste zaposlenih u datoteku
	 * @param file datoteka sa listom zaposlenih
	 */
	@Override
	public void saveUsers(String file) {
		SOSaveUsers.execute(file, users);	
	}

	/**
	 * Dodavanje novog zaposlenog u listu
	 * @param user novi zaposleni
	 */
	@Override
	public void addUser(User user) {
		SOAddUser.execute(users, user);
	}

	/**
	 * Provera username-a i lozinke
	 * @param user zaposleni
	 */
	@Override
	public User checkUsernamePassword(User user) {
		return SOCheckUsernamePassword.execute(users, user);
	}
}
