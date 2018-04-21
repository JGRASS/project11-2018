package classes.user;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUser {
	User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void testSetName() {
		String name = "Vladimir";
		user.setName(name);
		assertEquals(name, user.getName());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNameNull() {
		user.setName(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNameTooShort() {
		user.setName("A");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNameNotOnlyAlpha() {
		user.setName("Vladimir2>");
	}
	
	@Test
	public void testSetSurname() {
		String surname = "Belca";
		user.setSurname(surname);
		assertEquals(surname, user.getSurname());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSurnameNull() {
		user.setSurname(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSurnameTooShort() {
		user.setSurname("A");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSurnameNotOnlyAlpha() {
		user.setSurname("belc15a?");
	}
	
	@Test
	public void testSetUsername() {
		String username = "vlajs16";
		user.setUsername(username);
		assertEquals(username, user.getUsername());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameNull() {
		user.setUsername(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetUsernameTooShort() {
		user.setUsername("vlaj");
	}
	
	@Test
	public void testSetPassword() {
		String password = "sifra123";
		user.setPassword(password);
		assertEquals(password, user.getPassword());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordNull() {
		user.setPassword(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordTooShort() {
		user.setPassword("Pass3");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPasswordWithoutNumber() {
		user.setPassword("Password");
	}
	
	@Test 
	public void testEqualsTrue() {
		String username = "Vlajs16";
		String password = "Password34";
		user.setUsername(username);
		user.setPassword(password);
		
		User user2 = new User();
		user2.setUsername(username);
		user2.setPassword(password);
		
		assertTrue(user.equals(user2));
	}
	
	@Test 
	public void testEqualsFalse() {
		String username = "Vlajs16";
		String password = "Password34";
		user.setUsername(username);
		user.setPassword(password);
		
		User user2 = new User();
		user2.setUsername(username);
		user2.setPassword(password+"3");
		
		assertFalse(user.equals(user2));
	}
	
	@Test
	public void testToString() {
		String name = "Vladimir";
		String surname = "Belca";
		user.setName(name);
		user.setSurname(surname);
		
		assertEquals(name + " " + surname, user.toString());
	}
	
}
