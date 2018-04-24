package interfaces;

import classes.user.User;

public interface UsersInterface {
	
	public User checkUsernamePassword(User user);
	
	public void loadUsers(String file);
	
	public void saveUsers(String file);
	
	public void addUser(User user);
	
}
