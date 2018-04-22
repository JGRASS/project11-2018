package classes.coworker;

/**
 * Klasa koja predstavlja saradnike kompanije
 * @author vlajs16
 * @version 0.1 
 */
public class CoWorker {
	
	/**
	 * ID saradnika
	 */
	private int id;
	
	/**
	 * Ime kompanije sa kojom saradjujemo
	 */
	private String companyName;
	
	/**
	 * Zemlja porekla kompanije
	 */
	private String country;
	
	/**
	 * Kratak opis kompanije
	 */
	private String aboutCompany;
	
	/**
	 * Ime zaposlenog iz kompanije sa kojom saradjujemo
	 */
	private String name;
	
	/**
	 * Prezime zaposlenog iz kompanije sa kojom saradjujemo
	 */
	private String surname;
	
	/**
	 * Email saradnika
	 */
	private String email;
	
	/**
	 * Saradnikov kontakt telefon
	 */
	private String phone;
	
	
	/**
	 * Vraca ID saradnika
	 * @return id kao int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Postavlja novu vrenost atributa id
	 * @param id nova vrednost za id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vraca naziv kompanije 
	 * @return naziv kompanije kao String
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Postavlja novu vrednost za naziv kompanije
	 * @param companyName nova vrednost naziv kompanije
	 * @throws java.lang.RuntimeException ako je uneti naziv kompanije:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>prazan String</li>
	 * <li>duzine manje od 3 slova</li>
	 * </ul>
	 */
	public void setCompanyName(String companyName) {
		if (companyName.equals(null))
			throw new RuntimeException("Company name is null");
		if (companyName.isEmpty())
			throw new RuntimeException("Company name is empty string");
		if (companyName.length() < 3)
			throw new RuntimeException("Company name is too short");
		this.companyName = companyName;
	}
	
	/**
	 * Vraca zemlju porekla kompanije
	 * @return naziv drzave kao String
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Postavlja novu vrednost za zemlju porekla kompanije
	 * @param country nova vrednost drzave
	 * @throws java.lang.RuntimeException ako je uneti naziv drzave:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>prazan String</li>
	 * <li>duzine manje od 3 slova</li>
	 * </ul>
	 */
	public void setCountry(String country) {
		if (country.equals(null))
			throw new RuntimeException("Country is null");
		if (country.isEmpty())
			throw new RuntimeException("Country is empty string");
		if (country.length() < 3)
			throw new RuntimeException("Country name is too short");
		this.country = country;
	}
	
	/**
	 * Vraca kratak opis kompanije
	 * @return opis kompanije kao String
	 */
	public String getAboutCompany() {
		return aboutCompany;
	}
	
	/**
	 * Postavlja novu vrednost za opis kompanije
	 * @param aboutCompany nova vrednost opisa kompanije
	 * @throws java.lang.RuntimeException ako je uneti opis kompanije null vrednost
	 */
	public void setAboutCompany(String aboutCompany) {
		if (aboutCompany.equals(null))
			throw new RuntimeException("About company is null");
		this.aboutCompany = aboutCompany;
	}
	
	/**
	 * Proverava da li ceo uneti String cine slova
	 * @param text vrednost teksta
	 * @return true ako su sva slova, false ako nisu
	 */
	private boolean onlyAlpha(String text) {
		for (int i = 0; i < text.length(); i++)
			if (!Character.isAlphabetic(text.charAt(i)) && text.charAt(i) != ' ')
				return false;
		return true;
	}
	
	/**
	 * Vraca ime saradnika
	 * @return ime kao String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Postavlja novu vrednost za ime saradnika
	 * @param name nova vrednost imena
	 * @throws java.lang.RuntimeException ako je uneto ime saradnika:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>krace od 2 slova</li>
	 * <li>sadrzi neki drugi karakter pored slova</li>
	 * </ul>
	 */
	public void setName(String name) {
		if (name.equals(null))
			throw new RuntimeException("Name is null");
		if (name.length() < 2)
			throw new RuntimeException("Name is too short");
		if (!onlyAlpha(name))
			throw new RuntimeException("Name contains something that is not alphabetic character");
		this.name = name;
	}
	
	/**
	 * Vraca prezime saradnika
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
		if (surname.equals(null))
			throw new RuntimeException("Surname is null");
		if (surname.length() < 2)
			throw new RuntimeException("Surame is too short");
		if (!onlyAlpha(surname))
			throw new RuntimeException("Surame contains something that is not alphabetic character");
		this.surname = surname;
	}
	
	/**
	 * Vraca email saradnika
	 * @return email kao String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Postavlja novu vrednost za email saradnika
	 * @param email nova vrednost email-a
	 * @throws java.lang.RuntimeException ako je uneti email:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>prazan String</li>
	 * <li>ne sadrzi @ karakter</li>
	 * </ul>
	 */
	public void setEmail(String email) {
		if (email.equals(null))
			throw new RuntimeException("Email is null");
		if (email.isEmpty())
			throw new RuntimeException("Email is empty string");
		if (!email.contains("@"))
			throw new RuntimeException("Your email is not valid");
		this.email = email;
	}
	
	/**
	 * Vraca kontakt telefon saradnika
	 * @return phone kao String
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Postavlja novu vrednost za kontakt telefon
	 * @param phone nova vrednost kontakt telefona
	 * @throws java.lang.RuntimeException ako je uneti broj telefona:
	 * <ul style="list-style-type:circle">
	 * <li>prazan String</li>
	 * <li>sadrzi neki karakter pored brojeva</li>
	 * <li>nema '+' na pocetku</li>
	 * </ul>
	 */
	public void setPhone(String phone) {
		if (phone.equals(null))
			throw new RuntimeException("Phone is null");
		if (phone.isEmpty())
			throw new RuntimeException("Your phone is empty string");
		if (!validPhone(phone))
			throw new RuntimeException("Phone is not valid");
		this.phone = phone;
	}
	
	/**
	 * Proverava da li je dobro unet kontakt telefon
	 * @param phone vrednost broja telefona
	 * @return true ako je pravnilno unet, false ako nije
	 */
	private boolean validPhone(String phone) {
		for (int i = 0; i < phone.length(); i++) {
			if (i == 0 && phone.charAt(i) == '+')
				continue;
			if (!Character.isDigit(phone.charAt(i)))
				return false;
		}
		return true;
	}
	
	/**
	 * Proverava da li su dva saradnika ista
	 * Poredi po atributu id
	 * @return true ako su saradnici isti, a false ako nisu
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoWorker other = (CoWorker) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
