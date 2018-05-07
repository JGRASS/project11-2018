package classes.coworker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestContacts {
	private Contacts contacts;
	private CoWorker coWorker;

	@Before
	public void setUp() throws Exception {
		contacts = new Contacts();

		coWorker = new CoWorker("Komp", "Srbija", "Kompanija", "Petar", 
				"Petrovic", "pp@gmail.com", "0637822998");
	}

	@After
	public void tearDown() throws Exception {
		contacts = null;
		coWorker = null;
	}
	
	@Test 
	public void testAddContact() {
		contacts.addContact(coWorker);
		assertEquals(1, contacts.getContacts().size());
		assertEquals(coWorker, contacts.getContacts().get(0));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testAddContactNull() {
		contacts.addContact(null);
	}
	
	@Test
	public void testAddContactContains() {
		contacts.addContact(coWorker);
		contacts.addContact(coWorker);
		assertEquals(1, contacts.getContacts().size());
		assertEquals(coWorker, contacts.getContacts().get(0));
	}
	
	@Test
	public void testRemoveContact() {
		contacts.addContact(coWorker);

		contacts.removeContact(coWorker);
		assertEquals(0, contacts.getContacts().size());
	}
	
	@Test
	public void testRemoveContactNotSame() {
		contacts.addContact(coWorker);
		
		CoWorker coWorker2 = new CoWorker("Kompanija", "Makedonija", "Kompanija", "Marko", 
				"Petrovic", "pp@gmail.com", "0637822998");
		
		contacts.removeContact(coWorker2);
		assertEquals(1, contacts.getContacts().size());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testRemoveContactNull() {
		contacts.addContact(coWorker);
		contacts.removeContact(null);
	}
	
	@Test
	public void testSortContacts() {
		contacts.addContact(coWorker);
		
		CoWorker coWorker2 = new CoWorker("AKompanija", "Makedonija", "Kompanija", "Marko", 
				"Petrovic", "pp@gmail.com", "0637822998");
		
		contacts.addContact(coWorker2);
		contacts.SortContacts();
		
		assertEquals(coWorker2, contacts.getContacts().get(0));
		assertEquals(coWorker, contacts.getContacts().get(1));
	}
	
	
}
