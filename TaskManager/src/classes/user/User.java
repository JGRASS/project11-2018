package classes.user;

public class User {
	private String name;
	private String surname;
	private String username;
	private String password;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.equals(null))
			throw new RuntimeException("Name is null");
		if(name.length()<2)
			throw new RuntimeException("Name is too short");
		if(!onlyAlpha(name))
			throw new RuntimeException("Name contains something that is not alphabetic character");
		this.name = name;
	}
	
	private boolean onlyAlpha(String text) {
		for(int i = 0; i < text.length(); i++)
			if(!Character.isAlphabetic(text.charAt(i)) && text.charAt(i) != ' ')
				return false;
		return true;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		if(surname.equals(null))
			throw new RuntimeException("Surname is null");
		if(surname.length()<2)
			throw new RuntimeException("Surame is too short");
		if(!onlyAlpha(surname))
			throw new RuntimeException("Surame contains something that is not alphabetic character");
		this.surname = surname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		if(username.equals(null))
			throw new RuntimeException("Surname is null");
		if(username.length()<2)
			throw new RuntimeException("Surame is too short");
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password.equals(null))
			throw new RuntimeException("Password is null");
		if(password.length()<6)
			throw new RuntimeException("Password is too short");
		if(!tryPass(password))
			throw new RuntimeException("Password does not contain number");
		this.password = password;
	}
	
	private boolean tryPass(String pass) {
		for(int i = 0; i<pass.length(); i++) {
			if(Character.isDigit(pass.charAt(i)))
				return true;
		}
		return false;
	}
	
	
}
