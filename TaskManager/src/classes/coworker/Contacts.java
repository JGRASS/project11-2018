package classes.coworker;


import java.util.ArrayList;

import interfaces.ContactInterface;
import system_operations.contacts.SOAddContact;
import system_operations.contacts.SOFindContactByCompanyName;
import system_operations.contacts.SOFindContactByCountry;
import system_operations.contacts.SOFindContactByName;
import system_operations.contacts.SOLoadContacts;
import system_operations.contacts.SORemoveContact;
import system_operations.contacts.SOSaveContacts;
import system_operations.contacts.SOSortContacts;

public class Contacts implements ContactInterface{
	private ArrayList<CoWorker> contacts = new ArrayList<CoWorker>();

	public ArrayList<CoWorker> getContacts() {
		return contacts;
	}

	@Override
	public void LoadContacts(String file) {
		contacts = SOLoadContacts.execute(file);
	}

	@Override
	public void SaveContacts(String file) {
		SOSaveContacts.execute(file, contacts);
	}

	@Override
	public void SortContacts() {
		contacts = SOSortContacts.execute(contacts);	
	}

	@Override
	public ArrayList<CoWorker> FindContactByName(String name) {
		return SOFindContactByName.execute(contacts, name);
	}

	@Override
	public ArrayList<CoWorker> FindContactByCountry(String country) {
		return SOFindContactByCountry.execute(country, contacts);
	}

	@Override
	public ArrayList<CoWorker> FindContactByCompanyName(String companyName) {
		return SOFindContactByCompanyName.execute(contacts, companyName);
	}

	@Override
	public void addContact(CoWorker coWorker) {
		contacts = SOAddContact.execute(contacts, coWorker);
		
	}

	@Override
	public void removeContact(CoWorker coWorker) {
		contacts = SORemoveContact.execute(contacts, coWorker);
		
	}
}
