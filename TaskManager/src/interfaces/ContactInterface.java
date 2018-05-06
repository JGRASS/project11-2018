package interfaces;

import java.util.ArrayList;

import classes.coworker.CoWorker;

public interface ContactInterface {

	public void LoadContacts(String file);
	
	public void SaveContacts(String file);
	
	public void SortContacts();
	
	public void addContact(CoWorker coWorker);
	
	public void removeContact(CoWorker coWorker);
	
}
