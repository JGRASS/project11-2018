package gui.kontroler;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import classes.coworker.CoWorker;
import classes.coworker.Contacts;
import classes.task.Tasks;
import gui.AddContactFrame;
import gui.ContactsFrame;
import gui.HistoryFrame;
import gui.LogOutFrame;
import gui.MainFrame;
import gui.PasswordFrame;
import interfaces.TaskInterface;
import interfaces.ContactInterface;

public class GUIKontroler {
	
	public static TaskInterface ti = new Tasks();
	public static Contacts ci = new Contacts();
	
	public static PasswordFrame pf;
	public static MainFrame mf;
	public static ContactsFrame conf;
	public static AddContactFrame acf;
	
	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pf = new PasswordFrame();
					pf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static void showMainFrame() {
		mf = new MainFrame();
		mf.setLocationRelativeTo(pf);
		mf.setVisible(true);
		pf.setVisible(false);	
	}
	
	public static void searchContacts() {
		conf = new ContactsFrame();
		conf.setLocationRelativeTo(pf);
		conf.setVisible(true);
		
	}
	
	public static void loggingOut() {
		LogOutFrame lof = new LogOutFrame();
		lof.setLocationRelativeTo(pf);
		lof.setVisible(true);
	}

	public static void searchHistory() {
		HistoryFrame hf = new HistoryFrame();
		hf.setLocationRelativeTo(pf);
		hf.setVisible(true);
	}
	public static void addingContact() {
		acf = new AddContactFrame();
		acf.setLocationRelativeTo(conf);
		acf.setVisible(true);
	}
	public static void loggingIn() {
		pf = new PasswordFrame();
		pf.setVisible(true);
		pf.setLocationRelativeTo(mf);

		mf.setVisible(false);
	}
	public static void saveContact(String ConName, String ConSurname, String ConPhone, String ConEmail, String ComName, String ComCountry, String ComInfo) {
		try {
			CoWorker contact = new CoWorker();
			contact.setName(ConName);
			contact.setSurname(ConSurname);
			contact.setPhone(ConPhone);
			contact.setEmail(ConEmail);
			contact.setCompanyName(ComName);
			contact.setCountry(ComCountry);
			contact.setAboutCompany(ComInfo);
			
			ci.addContact(contact);
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(acf, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	public static void showAllContacts() {
		conf.showContacts(ci.getContacts());
	}
}
