package gui.kontroler;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classes.Paths;
import classes.coworker.CoWorker;
import classes.coworker.Contacts;
import classes.task.Task;
import classes.task.Tasks;
import classes.user.User;
import classes.users.Users;
import gui.AddContactFrame;
import gui.ContactsFrame;
import gui.HistoryFrame;

import gui.MainFrame;
import gui.PasswordFrame;
import interfaces.TaskInterface;
import interfaces.ContactInterface;

public class GUIKontroler {
	

	public static Tasks tm = new Tasks();
	public static Users users = new Users();
	public static Contacts contacts = new Contacts();
	
	public static User user;
	
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
					LoadTasks();
					LoadContacts();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void showMainFrame(User userr) {
		LoadUsers();
		User newUser = users.checkUsernamePassword(userr);
		
		if(newUser!=null) {
			user = newUser;
			LoadTasks();
			mf = new MainFrame();
			mf.setLocationRelativeTo(pf);
			mf.setHello(newUser);
			mf.setVisible(true);
			pf.setVisible(false);	
		}else {
			JOptionPane.showMessageDialog(pf, "Invalid password or username", "Error", JOptionPane.ERROR_MESSAGE);
			pf.clear();
		}
	
	}
	
	public static void searchContacts() {
		conf = new ContactsFrame();
		conf.setLocationRelativeTo(pf);
		conf.setVisible(true);
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
			
			contacts.addContact(contact);
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(acf, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
	public static void showAllContacts() {
		conf.showContacts(contacts.getContacts());
	}
	
	public static ArrayList<Task> showAllTasksToDo() {
		return tm.showTillToday(user);
	}
	
	//Funkcije koje ucitavaju juzere, kontakte i taskove iz fajlova
	public static void LoadUsers() {
		users.loadUsers(Paths.usersPath);
	}	
	public static void LoadContacts() {
		contacts.LoadContacts(Paths.contactsPath);
	}	
	public static void LoadTasks() {
		tm.LoadTasks(Paths.tasksPath, Paths.doneTasksPath);
	}
}
