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
					GUIKontroler.pf = new PasswordFrame();
					GUIKontroler.pf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void showMainFrame() {
		MainFrame mf = new MainFrame();
		mf.setLocationRelativeTo(pf);
		mf.setVisible(true);
		
	}
	
	public static void searchContacts() {
		ContactsFrame conf = new ContactsFrame();
		conf.setLocationRelativeTo(mf);
		conf.setVisible(true);
	}
	
	public static void loggingOut() {
		LogOutFrame lof = new LogOutFrame();
		lof.setLocationRelativeTo(mf);
		lof.setVisible(true);
	}

	public static void searchHistory() {
		HistoryFrame hf = new HistoryFrame();
		hf.setLocationRelativeTo(mf);
		hf.setVisible(true);
	}
	public static void addingContact() {
		AddContactFrame acf = new AddContactFrame();
		acf.setLocationRelativeTo(conf);
		acf.setVisible(true);
	}
	public static void loggingIn() {
		PasswordFrame pf = new PasswordFrame();
		pf.setLocationRelativeTo(mf);
		pf.setVisible(true);
	}
}
