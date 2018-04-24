package gui.kontroler;

import java.awt.EventQueue;

import classes.task.Tasks;
import gui.AddContactFrame;
import gui.ContactsFrame;
import gui.HistoryFrame;
import gui.LogOutFrame;
import gui.MainFrame;
import gui.PasswordFrame;
import interfaces.TaskInterface;

public class GUIKontroler {
	
	public static TaskInterface tm = new Tasks();
	
	public static PasswordFrame pf;
	public static MainFrame mf;
	public static ContactsFrame conf;
	
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
		AddContactFrame acf = new AddContactFrame();
		acf.setLocationRelativeTo(conf);
		acf.setVisible(true);
	}
	public static void loggingIn() {
		pf = new PasswordFrame();
		pf.setVisible(true);
		pf.setLocationRelativeTo(mf);

		mf.setVisible(false);
	}
}
