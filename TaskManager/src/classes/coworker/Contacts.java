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

/**
 * Klasa koja prikazuje kontakte
 * @author vlajs16
 */
public class Contacts implements ContactInterface{
	
	/**
	 * Lista kontakata
	 */
	private ArrayList<CoWorker> contacts = new ArrayList<CoWorker>();

	/**
	 * Vraca listu kontakata
	 * @return contacts lista kontakata
	 */
	public ArrayList<CoWorker> getContacts() {
		return contacts;
	}

	/**
	 * Ucitavanje kontakata iz datoteke
	 * @param file Naziv fajla iz kog ucitavamo kontakte
	 */
	@Override
	public void LoadContacts(String file) {
		contacts = SOLoadContacts.execute(file);
	}

	/**
	 * Cuvanje kontakata u datoteku
	 * @param file naziv fajla u koji upisujemo kontakte
	 */
	@Override
	public void SaveContacts(String file) {
		SOSaveContacts.execute(file, contacts);
	}

	/**
	 * Sortiranje liste kontakata
	 */
	@Override
	public void SortContacts() {
		contacts = SOSortContacts.execute(contacts);	
	}

	/**
	 * Pronalazenje kontakta prema imenu saradnika
	 * @param name ime kontakta koji trazimo
	 * @return odgovarajuci kontakt
	 */
	@Override
	public ArrayList<CoWorker> FindContactByName(String name) {
		return SOFindContactByName.execute(contacts, name);
	}

	/**
	 * Pronalazenje kontakata prema drzavi 
	 * @param country naziv zemlje za koju trazimo metode
	 * @return listu odgovarajucih kontakata
	 */
	@Override
	public ArrayList<CoWorker> FindContactByCountry(String country) {
		return SOFindContactByCountry.execute(country, contacts);
	}

	/**
	 * Pronalazenje kontakta prema imenu kompanije
	 * @param companyName naziv kompanije za koju trazimo 
	 * @return listu odgovarajucih kontakata
	 */
	@Override
	public ArrayList<CoWorker> FindContactByCompanyName(String companyName) {
		return SOFindContactByCompanyName.execute(contacts, companyName);
	}

	/**
	 * Dodavanje novog kontakta
	 * @param coWorker saradnik koga dodajemo u kontakte
	 */
	@Override
	public void addContact(CoWorker coWorker) {
		SOAddContact.execute(contacts, coWorker);
		
	}

	/**
	 * Brisanje kontakta
	 * @param coWorker saradnik koga brisemo iz kontakta
	 */
	@Override
	public void removeContact(CoWorker coWorker) {
		contacts = SORemoveContact.execute(contacts, coWorker);
		
	}
}
