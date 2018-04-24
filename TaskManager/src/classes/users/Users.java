package classes.users;

import java.util.LinkedList;

import classes.user.User;
import interfaces.UsersInterface;

public class Users implements UsersInterface{
	
	private LinkedList<User> users = new LinkedList<User>();

	public LinkedList<User> getUsers() {
		return users;
	}

	public void setUsers(LinkedList<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public boolean checkUsernamePassword(User user) {
		if(users.contains(user))
			return true;
		return false;
	}
	
	

}