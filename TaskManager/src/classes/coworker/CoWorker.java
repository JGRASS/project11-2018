package classes.coworker;

public class CoWorker {
	private int id;
	private String companyName;
	private String country;
	private String aboutCompany;
	private String name;
	private String surname;
	private String email;
	private String phone;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		if (companyName.equals(null))
			throw new RuntimeException("Company name is null");
		if (companyName.isEmpty())
			throw new RuntimeException("Company name is empty string");
		if (companyName.length() < 3)
			throw new RuntimeException("Company name is too short");
		this.companyName = companyName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if (country.equals(null))
			throw new RuntimeException("Country is null");
		if (country.isEmpty())
			throw new RuntimeException("Country is empty string");
		if (country.length() < 3)
			throw new RuntimeException("Country name is too short");
		this.country = country;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		if (aboutCompany.equals(null))
			throw new RuntimeException("About company is null");
		this.aboutCompany = aboutCompany;
	}

	private boolean onlyAlpha(String text) {
		for (int i = 0; i < text.length(); i++)
			if (!Character.isAlphabetic(text.charAt(i)) && text.charAt(i) != ' ')
				return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.equals(null))
			throw new RuntimeException("Name is null");
		if (name.length() < 2)
			throw new RuntimeException("Name is too short");
		if (!onlyAlpha(name))
			throw new RuntimeException("Name contains something that is not alphabetic character");
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname.equals(null))
			throw new RuntimeException("Surname is null");
		if (surname.length() < 2)
			throw new RuntimeException("Surame is too short");
		if (!onlyAlpha(surname))
			throw new RuntimeException("Surame contains something that is not alphabetic character");
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.equals(null))
			throw new RuntimeException("Email is null");
		if (email.isEmpty())
			throw new RuntimeException("Email is empty string");
		if (!email.contains("@"))
			throw new RuntimeException("Your email is not valid");
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone.equals(null))
			throw new RuntimeException("Phone is null");
		if (phone.isEmpty())
			throw new RuntimeException("Your phone is empty string");
		if (!validPhone(phone))
			throw new RuntimeException("Phone is not valid");
		this.phone = phone;
	}

	private boolean validPhone(String phone) {
		for (int i = 0; i < phone.length(); i++) {
			if (i == 0 && phone.charAt(i) == '+')
				continue;
			if (!Character.isDigit(phone.charAt(i)))
				return false;
		}
		return true;
	}

}
