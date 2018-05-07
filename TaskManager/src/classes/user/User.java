package classes.user;

import java.io.Serializable;

/**
 * Klasa koja predstavlja zaposlenog
 * @author vlajs16
 * @version 0.1
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8811326673272297116L;

	/**
	 * Ime zaposlenog
	 */
	private String name;
	
	/**
	 * Prezime zaposlenog
	 */
	private String surname;
	
	/**
	 * Username zaposlenog
	 */
	private String username;
	
	/**
	 * Lozinka zaposlenog
	 */
	private String password;

	/**
	 * Konstuktor klase User
	 */
	public User() {
		
	}
	/**
	 * Konstruktor klase User
	 * @param name ime zaposlenog
	 * @param surname prezime zaposlenog
	 * @param username username zaposlenog
	 * @param password sifra zaposlenog
	 */
	public User(String name, String surname, String username, String password) {
		this.setName(name);
		this.setSurname(surname);
		this.setUsername(username);
		this.setPassword(password);
	}
	
	/**
	 * Vraca String sa imenom i prezimenom zaposlenog
	 * @return ime i prezime zaposlenog kao String
	 */
	@Override
	public String toString() {
		return this.name + " " + this.surname;
	}
	
	/**
	 * Vraca ime zaposlenog
	 * @return ime kao String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Postavlja novu vrednost za ime zaposlenog
	 * @param name nova vrednost imena
	 * @throws java.lang.RuntimeException ako je uneto ime saradnika:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>krace od 2 slova</li>
	 * <li>sadrzi neki drugi karakter pored slova</li>
	 * </ul>
	 */
	public void setName(String name) {
		if(name.equals(null))
			throw new RuntimeException("Name is null");
		if(name.length()<2)
			throw new RuntimeException("Name is too short");
		if(!onlyAlpha(name))
			throw new RuntimeException("Name contains something that is not alphabetic character");
		this.name = name;
	}
	
	/**
	 * Proverava da li ceo uneti String cine slova
	 * @param text vrednost teksta
	 * @return true ako su sva slova, false ako nisu
	 */
	private boolean onlyAlpha(String text) {
		for(int i = 0; i < text.length(); i++)
			if(!Character.isAlphabetic(text.charAt(i)) && text.charAt(i) != ' ')
				return false;
		return true;
	}
	
	/**
	 * Vraca prezime zaposlenog
	 * @return prezime kao String
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Postavlja novu vrednost za prezime saradnika
	 * @param surname nova vrednost prezimena
	 * @throws java.lang.RuntimeException ako je uneto prezime saradnika:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>krace od 2 slova</li>
	 * <li>sadrzi neki drugi karakter pored slova</li>
	 * </ul>
	 */
	public void setSurname(String surname) {
		if(surname.equals(null))
			throw new RuntimeException("Surname is null");
		if(surname.length()<2)
			throw new RuntimeException("Surame is too short");
		if(!onlyAlpha(surname))
			throw new RuntimeException("Surame contains something that is not alphabetic character");
		this.surname = surname;
	}
	
	/**
	 * Vraca username zaposlenog
	 * @return username kao String
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Postavlja novu vrednost za username saradnika
	 * @param username nova vrednost username-a
	 * @throws java.lang.RuntimeException ako je uneti username:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>kraci od 5 karaktera</li>
	 * </ul>
	 */
	public void setUsername(String username) {
		if(username.equals(null))
			throw new RuntimeException("Username is null");
		if(username.length()<5)
			throw new RuntimeException("Username is too short");
		this.username = username;
	}
	
	/**
	 * Vraca lozinku zaposlenog
	 * @return lozinku kao String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Postavlja novu vrednost za lozinku saradnika
	 * @param password nova vrednost lozinke
	 * @throws java.lang.RuntimeException ako je uneta lozinka:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>kraca od 6 karaktera</li>
	 * <li>ne sadrzi makar jedan broj</li>
	 * </ul>
	 */
	public void setPassword(String password) {
		if(password.equals(null))
			throw new RuntimeException("Password is null");
		if(password.length()<6)
			throw new RuntimeException("Password is too short");
		if(!tryPass(password))
			throw new RuntimeException("Password does not contain number");
		this.password = password;
	}
	
	/**
	 * Proverava da li je dobro uneta lozinka
	 * @param pass vrednost lozinke
	 * @return true ako sadrzi broj, false ako ne sadrzi
	 */
	private boolean tryPass(String pass) {
		for(int i = 0; i<pass.length(); i++) {
			if(Character.isDigit(pass.charAt(i)))
				return true;
		}
		return false;
	}

	/**
	 * Proverava da li su dva saradnika ista
	 * Poredi po atributima: username i password
	 * @return true ako su isti, false ako nisu
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
