package classes.coworker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCoWorker {
	CoWorker cow;

	@Before
	public void setUp() throws Exception {
		cow = new CoWorker();
	}

	@After
	public void tearDown() throws Exception {
		cow = null;
	}

	@Test
	public void testSetCompanyName() {
		String name = "Task Manager Company";
		cow.setCompanyName(name);
		assertEquals(name, cow.getCompanyName());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetCompanyNameNull() {
		cow.setCompanyName(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetCompanyNameEmptyString() {
		cow.setCompanyName("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetCompanyNameTooShort() {
		cow.setCompanyName("An");
	}
	
	@Test
	public void testSetCountry() {
		String country = "Serbia";
		cow.setCountry(country);
		assertEquals(country, cow.getCountry());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetCountryNull() {
		cow.setCompanyName(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetCountryEmptyString() {
		cow.setCompanyName("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetCountryTooShort() {
		cow.setCompanyName("Se");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetAboutCompany() {
		cow.setAboutCompany(null);
	}
	
	@Test 
	public void testSetName() {
		String name = "Vladimir";
		cow.setName(name);
		assertEquals(name, cow.getName());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNameNull() {
		cow.setName(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNameEmptyString() {
		cow.setName("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNameNotOnlyAlphabetic() {
		cow.setName("Vlad8imir");
	}
	
	@Test 
	public void testSetSurname() {
		String name = "Belca";
		cow.setSurname(name);
		assertEquals(name, cow.getSurname());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSurameNull() {
		cow.setSurname(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSurameTooShort() {
		cow.setSurname("E");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSurameWithNumber() {
		cow.setSurname("Belc2a");
	}
	
	@Test
	public void setEmail() {
		String email = "vladimir.belca@gmail.com";
		cow.setEmail(email);
		assertEquals(email, cow.getEmail());		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void setEmailNull() {
		cow.setEmail(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void setEmailEmptyString() {
		cow.setEmail("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void setEmailWithoutAt() {
		cow.setEmail("vladimir.belcagmail.com");
	}
	
	@Test
	public void setPhone1() {
		String phone = "064555321";
		cow.setPhone(phone);
		assertEquals(phone, cow.getPhone());
	}
	
	@Test
	public void setPhone2() {
		String phone = "+38164555321";
		cow.setPhone(phone);
		assertEquals(phone, cow.getPhone());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void setPhoneNull() {
		cow.setPhone(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void setPhoneEmptyString() {
		cow.setPhone("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void setPhoneWithChar() {
		cow.setPhone("098(djsi");
	}
	
	@Test
	public void testSetId() {
		cow.setId(1);
		assertEquals(1, cow.getId());
	}
}

