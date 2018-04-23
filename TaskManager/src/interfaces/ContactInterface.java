package interfaces;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public interface ContactInterface {

	public void LoadContacts(String file);
	
	public void SaveContacts(String file);
	
	public void SortContacts();
	
	public ArrayList<CoWorker> FindContactByName(String name);
	
	public ArrayList<CoWorker> FindContactByCountry(String country);
	
	public ArrayList<CoWorker> FindContactByCompanyName(String companyName);
	
	public void addContact(CoWorker coWorker);
	
	public void removeContact(CoWorker coWorker);
	
}
