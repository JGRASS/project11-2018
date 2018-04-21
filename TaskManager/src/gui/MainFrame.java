package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private JMenuItem mntmLogOut;
	private JMenuItem mntmExit;
	private JMenuItem mntmNewContact;
	private JMenuItem mntmNewTask;
	private JMenuItem mntmAbout;
	private JPanel panelWest;
	private JLabel lblYourTasksFor;
	private JScrollPane scrollPane;
	private JTextArea textAreaTasks;
	private JLabel lblHello;
	private JPanel panelEast;
	private JButton btnAddTask;
	private JButton btnContacts;
	private JButton btnHistory;
	private JButton btnLogOut;
	private JLabel lblCUrrentDate;
	private JPanel panelNorth;
	private JPanel panelCenter;
	private JLabel lblTasksDetails;
	private JScrollPane scrollPaneCenter;
	private JPanel panelSouth;
	private JSplitPane splitPane;
	private JScrollPane scrollPaneLeft;
	private JScrollPane scrollPaneRight;
	private JTextArea textAreaRight;
	private JSeparator separator;
	private JTextPane textPane;
	private JPanel panelButton;
	private JPanel panelContact;
	private JLabel lblImportantContacts;
	private JButton btnTaskCompleted;
	private MainFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/icons/taskManager.jpg")));
		setTitle("TaskManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//int width = (int) tk.getScreenSize().getWidth();
		//int height = (int) tk.getScreenSize().getHeight();
		setBounds(100, 100, 900, 700);
		//this.setSize(977, 668);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 20, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelWest(), BorderLayout.WEST);
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getPanelNorth(), BorderLayout.NORTH);
		contentPane.add(getPanelCenter(), BorderLayout.CENTER);
		contentPane.add(getPanelSouth(), BorderLayout.SOUTH);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnEdit());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("FIle");
			mnFile.add(getMntmLogOut());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnEdit() {
		if (mnEdit == null) {
			mnEdit = new JMenu("Edit");
			mnEdit.add(getMntmNewTask());
			mnEdit.add(getMntmNewContact());
		}
		return mnEdit;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmLogOut() {
		if (mntmLogOut == null) {
			mntmLogOut = new JMenuItem("Log out");
			mntmLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loggingOut();
				}
			});
			mntmLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		}
		return mntmLogOut;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int exit = JOptionPane.showConfirmDialog(mainFrame, "Do you want to quit TaskManager?", "Exit", JOptionPane.YES_NO_OPTION);
					if (exit == JOptionPane.YES_OPTION)
						System.exit(0);
				}
			});
		}
		return mntmExit;
	}
	private JMenuItem getMntmNewContact() {
		if (mntmNewContact == null) {
			mntmNewContact = new JMenuItem("New contact");
			mntmNewContact.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					searchContacts();
				}
			});
			mntmNewContact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
			mntmNewContact.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		}
		return mntmNewContact;
	}
	private JMenuItem getMntmNewTask() {
		if (mntmNewTask == null) {
			mntmNewTask = new JMenuItem("New task");
			mntmNewTask.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
			mntmNewTask.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		}
		return mntmNewTask;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(mainFrame, "Neki tekstic", "About TaskManager", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAbout.setIcon(null);
		}
		return mntmAbout;
	}
	private JLabel getLblYourTasksFor() {
		if (lblYourTasksFor == null) {
			lblYourTasksFor = new JLabel("Your tasks for today:");
		}
		return lblYourTasksFor;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextAreaTasks());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaTasks() {
		if (textAreaTasks == null) {
			textAreaTasks = new JTextArea();
			textAreaTasks.setEditable(false);
		}
		return textAreaTasks;
	}
	private JLabel getLblHello() {
		if (lblHello == null) {
			lblHello = new JLabel("Hello, Teodora Acimov");
		}
		return lblHello;
	}
	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setPreferredSize(new Dimension(250, 0));
			panelWest.setLayout(new BorderLayout(0, 10));
			panelWest.add(getLblYourTasksFor(), BorderLayout.NORTH);
			panelWest.add(getScrollPane());
		}
		return panelWest;
	}
	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(150, 10));
			panelEast.setLayout(null);
			panelEast.add(getBtnAddTask());
			panelEast.add(getBtnHistory());
			panelEast.add(getBtnContacts());
			panelEast.add(getBtnTaskCompleted());
		}
		return panelEast;
	}
	private JButton getBtnAddTask() {
		if (btnAddTask == null) {
			btnAddTask = new JButton("Add task");
			btnAddTask.setBounds(10, 37, 140, 34);
		}
		return btnAddTask;
	}
	private JButton getBtnContacts() {
		if (btnContacts == null) {
			btnContacts = new JButton("Contacts");
			btnContacts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					searchContacts();
				}
			});
			btnContacts.setBounds(10, 148, 140, 34);
		}
		return btnContacts;
	}
	private JButton getBtnHistory() {
		if (btnHistory == null) {
			btnHistory = new JButton("History");
			btnHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					searchHistory();
				}

			});
			btnHistory.setBounds(10, 205, 140, 34);
		}
		return btnHistory;
	}
	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("Log out");
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					loggingOut();
				}

			});
			btnLogOut.setBounds(10, 21, 140,34);
		}
		return btnLogOut;
	}
	private JLabel getLblCUrrentDate() {
		if (lblCUrrentDate == null) {
			lblCUrrentDate = new JLabel("");
			
			Calendar date = new GregorianCalendar();
			int day = date.get(Calendar.DAY_OF_MONTH);
			int month = date.get(Calendar.MONTH) + 1;
			int year = date.get(Calendar.YEAR);
			lblCUrrentDate.setText("Date: "+day+"."+month+"."+year+".      ");
		}
		return lblCUrrentDate;
	}
	private JPanel getPanelNorth() {
		if (panelNorth == null) {
			panelNorth = new JPanel();
			panelNorth.setPreferredSize(new Dimension(50, 80));
			panelNorth.setLayout(new BorderLayout(5, 0));
			panelNorth.add(getSeparator(), BorderLayout.SOUTH);
			panelNorth.add(getLblHello(), BorderLayout.CENTER);
			panelNorth.add(getLblCUrrentDate(), BorderLayout.EAST);
		}
		return panelNorth;
	}
	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(new BorderLayout(1000,10));
			panelCenter.add(getLblTasksDetails(), BorderLayout.NORTH);
			panelCenter.add(getScrollPaneCenter());
		}
		return panelCenter;
	}
	private JLabel getLblTasksDetails() {
		if (lblTasksDetails == null) {
			lblTasksDetails = new JLabel("Task's details:");
		}
		return lblTasksDetails;
	}
	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			scrollPaneCenter.setViewportView(getSplitPane());
		}
		return scrollPaneCenter;
	}
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.setPreferredSize(new Dimension(50, 80));
			panelSouth.setLayout(new BorderLayout(0, 0));
			panelSouth.add(getPanelButton(), BorderLayout.EAST);
		}
		return panelSouth;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(13);
			splitPane.setBorder(new EmptyBorder(15, 15, 15, 15));
			splitPane.setLeftComponent(getScrollPaneLeft());
			splitPane.setRightComponent(getScrollPaneRight());
			splitPane.setDividerLocation(600);
		}
		return splitPane;
	}
	private JScrollPane getScrollPaneLeft() {
		if (scrollPaneLeft == null) {
			scrollPaneLeft = new JScrollPane();
			scrollPaneLeft.setColumnHeaderView(getTextPane());
			scrollPaneLeft.setViewportView(getPanelContact());
		}
		return scrollPaneLeft;
	}
	private JScrollPane getScrollPaneRight() {
		if (scrollPaneRight == null) {
			scrollPaneRight = new JScrollPane();
			scrollPaneRight.setViewportView(getTextAreaRight());
		}
		return scrollPaneRight;
	}
	private JTextArea getTextAreaRight() {
		if (textAreaRight == null) {
			textAreaRight = new JTextArea();
			textAreaRight.setEditable(false);
			textAreaRight.setText("");
		}
		return textAreaRight;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setPreferredSize(new Dimension(0, 15));
			separator.setAlignmentX(Component.LEFT_ALIGNMENT);
			separator.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		}
		return separator;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setText("\nHere you may find all details about selected task. Downbelow you may find special informations about your co-workers with whom you need to communicate. On the right you may read step by step about everythig related to this task.");
			textPane.setBackground(SystemColor.menu);
		}
		return textPane;
	}
	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			panelButton.setPreferredSize(new Dimension(150, 40));
			panelButton.setLayout(null);
			panelButton.add(getBtnLogOut());
		}
		return panelButton;
	}
	private JPanel getPanelContact() {
		if (panelContact == null) {
			panelContact = new JPanel();
			panelContact.setLayout(null);
			panelContact.add(getLblImportantContacts());
		}
		return panelContact;
	}
	private JLabel getLblImportantContacts() {
		if (lblImportantContacts == null) {
			lblImportantContacts = new JLabel("Important contacts:");
			lblImportantContacts.setBounds(10, 41, 237, 14);
		}
		return lblImportantContacts;
	}
	private JButton getBtnTaskCompleted() {
		if (btnTaskCompleted == null) {
			btnTaskCompleted = new JButton("Task completed");
			btnTaskCompleted.setBounds(10, 92, 140, 34);
		}
		return btnTaskCompleted;
	}
	
	private void searchContacts() {
		ContactsFrame conf = new ContactsFrame(mainFrame);
		conf.setVisible(true);
	}
	
	private void loggingOut() {
		LogOutFrame lof = new LogOutFrame(mainFrame);
		lof.setVisible(true);
	}

	private void searchHistory() {
		HistoryFrame hf = new HistoryFrame(mainFrame);
		hf.setVisible(true);
	}
}
