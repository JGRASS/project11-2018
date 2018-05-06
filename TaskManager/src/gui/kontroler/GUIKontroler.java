package gui.kontroler;

import java.awt.EventQueue;
import java.util.GregorianCalendar;
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
import gui.AddTaskFrame;
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

	public static void addingContactTask() {
		acf = new AddContactFrame();
		acf.setLocationRelativeTo(atf);
		acf.setVisible(true);
	}
	public static void addingNewTask() {
		atf = new AddTaskFrame();
		atf.setLocationRelativeTo(mf);
		atf.setVisible(true);
	}
	public static void loggingIn() {
		pf = new PasswordFrame();
		pf.setVisible(true);
		pf.setLocationRelativeTo(mf);

		mf.setVisible(false);
	}
	
	public static void saveContact(String ConName, String ConSurname, String ConPhone, String ConEmail, String ComName, String ComCountry, String ComInfo) {
		
//			try {
				CoWorker contact = new CoWorker();
				contact.setName(ConName);
				contact.setSurname(ConSurname);
				contact.setPhone(ConPhone);
				contact.setEmail(ConEmail);
				contact.setCompanyName(ComName);
				contact.setCountry(ComCountry);
				contact.setAboutCompany(ComInfo);
				
				contacts.addContact(contact);
				contacts.SaveContacts(Paths.contactsPath);
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
//			}
//			
		
	}
	
	
	public static void saveTask(String title, CoWorker coworker, GregorianCalendar date, String description ) {
		try {
			Task task = new Task();
			task.setTaskTitle(title);
			task.setCoWorker(coworker);
			task.setDate(date);
			task.setDescription(description);
			task.setDone(false);
//			System.out.println(task);
			tm.AddTaskToDo(task);
			tm.saveTasks(Paths.tasksPath, Paths.doneTasksPath);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(atf, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void taskCompleted(Task task) {
		tm.AddTaskDone(task);
		tm.saveTasks(Paths.tasksPath, Paths.doneTasksPath);
	}
	
	
	//Funkcije za prikazivanje podataka u listama i kombo boksevima
	public static void refreshContacts() {
		conf.showContacts();
		atf.showContacts();
	}
	
	public static void refreshTasks() {
		mf.showTasks();
	}
	
	public static ArrayList<CoWorker> showAllContacts() {
		return contacts.getContacts();
	}
	
	public static ArrayList<Task> showAllTasksToDo() {
		return tm.showTillToday(user);
	}
	public static ArrayList<Task> showDoneTasks(){
		return tm.getDoneTasks();
	}
	public static ArrayList<Task> showTasksToDo(){
		return tm.getTasks();
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
