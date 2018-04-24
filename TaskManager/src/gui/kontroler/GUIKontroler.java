package gui.kontroler;

import java.awt.EventQueue;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;


import classes.coworker.CoWorker;
import classes.coworker.Contacts;
import classes.task.Task;
import classes.task.Tasks;
import classes.user.User;
import classes.users.Users;
import gui.AddContactFrame;
import gui.AddTaskFrame;
import gui.ContactsFrame;
import gui.HistoryFrame;

import gui.MainFrame;
import gui.PasswordFrame;
import interfaces.TaskInterface;
import interfaces.ContactInterface;

public class GUIKontroler {
	

	public static TaskInterface tm = new Tasks();
	public static Users users = new Users();
	
	private static User user1 = new User();
	
	private static void metodica() {
		user1.setName("Teodora");
		user1.setSurname("Acimov");
		user1.setUsername("IceTea");
		user1.setPassword("Nemaspojma1");
		users.addUser(user1);
	}

	public static TaskInterface ti = new Tasks();
	public static Contacts ci = new Contacts();
	
	public static PasswordFrame pf;
	public static MainFrame mf;
	public static ContactsFrame conf;
	public static AddContactFrame acf;
	public static AddTaskFrame atf;
	
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

	public static void showMainFrame(User user) {
		metodica();
		User newUser = users.checkUsernamePassword(user);
		if(newUser!=null) {
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
			
			ci.addContact(contact);
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(acf, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	public static void showAllContacts() {
		conf.showContacts(ci.getContacts());
	}
	
	public static void showCoWorkers() {
		atf.showContacts(ci.getContacts());
	}
	
	public static void saveTask(String title, CoWorker coworker, GregorianCalendar date, String description ) {
		try {
			Task task = new Task();
			task.setTaskTitle(title);
			task.setCoWorker(coworker);
			task.setDate(date);
			task.setComment("");
			task.setDescription(description);
			task.setDone(false);
			
			tm.AddTaskToDo(task);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(atf, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void addingContactTask() {
		acf = new AddContactFrame();
		acf.setLocationRelativeTo(atf);
		acf.setVisible(true);
	}
	
}
