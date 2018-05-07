package classes.user;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUsers {

	private Users users;
	private User user;
	
	@Before
	public void setUp() throws Exception {
		users = new Users();
		user = new User("Marko", "Stanimirov", "stanimirko", "najjaciMarko12");
	}

	@After
	public void tearDown() throws Exception {
		users = null;
	}

	
	@Test (expected = java.lang.RuntimeException.class)
	public void testAddUserNull() {
		users.addUser(null);
	}
	
	@Test
	public void testAddUser() {
		users.addUser(user);
		assertTrue(users.getUsers().contains(user));
	}
	
	@Test
	public void testAddUserContains() {
		users.addUser(user);
		users.addUser(user);
		assertEquals(1, users.getUsers().size());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testCheckUsernamePasswordNull() {
		users.checkUsernamePassword(null);
	}
	
	@Test
	public void testCheckUsernamePasswordTrue() {
		users.addUser(user);
		User newUser = new User();
		newUser.setUsername("stanimirko");
		newUser.setPassword("najjaciMarko12");
		assertTrue(users.getUsers().contains(newUser));
	}
	
	@Test
	public void testCheckUsernamePasswordFalse() {
		users.addUser(user);
		User newUser = new User();
		newUser.setUsername("staniMir");
		newUser.setPassword("najjaciMarko12");
		assertFalse(users.getUsers().contains(newUser));
	}

}
