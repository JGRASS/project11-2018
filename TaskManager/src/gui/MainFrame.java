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
import javax.swing.JSeparator;

import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JList;

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
	private JSeparator separator;
	private JPanel panelButton;
	private JPanel panelContact;
	private JLabel lblImportantContacts;
	private MainFrame mainFrame;
	private JLabel lblCompanyName;
	private JLabel lblCoworkerName;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblCountry;
	private JLabel lblCOmpanyNameFilled;
	private JLabel lblCoWorkerNAmeFilled;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JLabel lblNekaZemljaCuda;
	private JPanel panelDetailsOfTask;
	private JPanel panelTaskDescription;
	private JScrollPane scrollPaneTaskDescription;
	private JTextArea textAreaTaskDescription;
	private JTextArea textAreaComments;
	private JPanel panelPomocni;
	private JPanel panelAboutCompany;
	private JTextArea textAreaAboutCompany;
	private JPanel panelNorthAbout;
	private JPanel panelSoutnAbout;
	private JPanel panelSouthAbout;
	private JPanel panelWestAbout;
	private JPanel panelEastAbout;
	private JPanel panelContactDetails;
	private JPanel panelLeftButton;
	private JButton button;
	private JList listTasks;

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
		setBounds(100, 100, 1080, 1500);
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
		
		mainFrame = this;
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
			//mntmNewContact.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		}
		return mntmNewContact;
	}
	private JMenuItem getMntmNewTask() {
		if (mntmNewTask == null) {
			mntmNewTask = new JMenuItem("New task");
			mntmNewTask.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
			//mntmNewTask.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
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
			scrollPane.setViewportView(getPanelPomocni());
		}
		return scrollPane;
	}
	private JLabel getLblHello() {
		if (lblHello == null) {
			lblHello = new JLabel("Hello");
			//AddContactFrame
			
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
			btnContacts.setBounds(10, 102, 140, 34);
			btnContacts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					searchContacts();
				}
			});
		}
		return btnContacts;
	}
	private JButton getBtnHistory() {
		if (btnHistory == null) {
			btnHistory = new JButton("History");
			btnHistory.setBounds(10, 167, 140, 34);
			btnHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					searchHistory();
				}

			});
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
			panelSouth.add(getPanelLeftButton(), BorderLayout.WEST);
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
			splitPane.setDividerLocation(350);
		}
		return splitPane;
	}
	private JScrollPane getScrollPaneLeft() {
		if (scrollPaneLeft == null) {
			scrollPaneLeft = new JScrollPane();
			scrollPaneLeft.setViewportView(getPanelContact());
		}
		return scrollPaneLeft;
	}
	private JScrollPane getScrollPaneRight() {
		if (scrollPaneRight == null) {
			scrollPaneRight = new JScrollPane();
			scrollPaneRight.setViewportView(getPanelDetailsOfTask());
		}
		return scrollPaneRight;
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
			panelContact.setLayout(new BorderLayout(0, 0));
			panelContact.add(getPanelAboutCompany(), BorderLayout.SOUTH);
			panelContact.add(getPanelContactDetails(), BorderLayout.CENTER);
		}
		return panelContact;
	}
	private JLabel getLblImportantContacts() {
		if (lblImportantContacts == null) {
			lblImportantContacts = new JLabel("Contacts:");
			lblImportantContacts.setBounds(10, 11, 113, 14);
		}
		return lblImportantContacts;
	}
	private JLabel getLblCompanyName() {
		if (lblCompanyName == null) {
			lblCompanyName = new JLabel("Company name:");
			lblCompanyName.setBounds(24, 57, 99, 14);
		}
		return lblCompanyName;
	}
	private JLabel getLblCoworkerName() {
		if (lblCoworkerName == null) {
			lblCoworkerName = new JLabel("Co-worker name:");
			lblCoworkerName.setBounds(24, 97, 99, 14);
		}
		return lblCoworkerName;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(24, 134, 46, 14);
		}
		return lblEmail;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone:");
			lblPhone.setBounds(24, 174, 46, 14);
		}
		return lblPhone;
	}
	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel("Country:");
			lblCountry.setBounds(24, 213, 99, 14);
		}
		return lblCountry;
	}
	private JLabel getLblCOmpanyNameFilled() {
		if (lblCOmpanyNameFilled == null) {
			lblCOmpanyNameFilled = new JLabel("");
			lblCOmpanyNameFilled.setBounds(133, 57, 184, 14);
		}
		return lblCOmpanyNameFilled;
	}
	private JLabel getLblCoWorkerNAmeFilled() {
		if (lblCoWorkerNAmeFilled == null) {
			lblCoWorkerNAmeFilled = new JLabel("");
			lblCoWorkerNAmeFilled.setBounds(133, 97, 184, 14);
		}
		return lblCoWorkerNAmeFilled;
	}
	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setBounds(133, 131, 186, 20);
			textFieldEmail.setEditable(false);
			textFieldEmail.setBackground(SystemColor.control);
			textFieldEmail.setBorder(null);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}
	private JTextField getTextFieldPhone() {
		if (textFieldPhone == null) {
			textFieldPhone = new JTextField();
			textFieldPhone.setBounds(133, 171, 184, 20);
			textFieldPhone.setEditable(false);
			textFieldPhone.setColumns(10);
			textFieldPhone.setBorder(null);
			textFieldPhone.setBackground(SystemColor.menu);
		}
		return textFieldPhone;
	}
	private JLabel getLblNekaZemljaCuda() {
		if (lblNekaZemljaCuda == null) {
			lblNekaZemljaCuda = new JLabel("");
			lblNekaZemljaCuda.setBounds(139, 213, 184, 14);
		}
		return lblNekaZemljaCuda;
	}
	private JPanel getPanelDetailsOfTask() {
		if (panelDetailsOfTask == null) {
			panelDetailsOfTask = new JPanel();
			panelDetailsOfTask.setLayout(new BorderLayout(0, 0));
			panelDetailsOfTask.add(getPanelTaskDescription(), BorderLayout.NORTH);
			panelDetailsOfTask.add(getTextAreaComments(), BorderLayout.CENTER);
		}
		return panelDetailsOfTask;
	}
	private JPanel getPanelTaskDescription() {
		if (panelTaskDescription == null) {
			panelTaskDescription = new JPanel();
			panelTaskDescription.setPreferredSize(new Dimension(150, 275));
			panelTaskDescription.setLayout(new BorderLayout(0, 0));
			panelTaskDescription.add(getScrollPaneTaskDescription());
		}
		return panelTaskDescription;
	}
	private JScrollPane getScrollPaneTaskDescription() {
		if (scrollPaneTaskDescription == null) {
			scrollPaneTaskDescription = new JScrollPane();
			scrollPaneTaskDescription.setViewportView(getTextAreaTaskDescription());
		}
		return scrollPaneTaskDescription;
	}
	private JTextArea getTextAreaTaskDescription() {
		if (textAreaTaskDescription == null) {
			textAreaTaskDescription = new JTextArea();
			textAreaTaskDescription.setEditable(false);
			textAreaTaskDescription.setBackground(SystemColor.control);
		}
		return textAreaTaskDescription;
	}
	private JTextArea getTextAreaComments() {
		if (textAreaComments == null) {
			textAreaComments = new JTextArea();
			textAreaComments.setBorder(new TitledBorder(null, "Comments", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return textAreaComments;
	}
	private JPanel getPanelPomocni() {
		if (panelPomocni == null) {
			panelPomocni = new JPanel();
			panelPomocni.setLayout(new BorderLayout(0, 0));
			panelPomocni.add(getListTasks(), BorderLayout.CENTER);
		}
		return panelPomocni;
	}
	private JPanel getPanelAboutCompany() {
		if (panelAboutCompany == null) {
			panelAboutCompany = new JPanel();
			panelAboutCompany.setPreferredSize(new Dimension(100, 180));
			panelAboutCompany.setLayout(new BorderLayout(0, 0));
			panelAboutCompany.add(getTextAreaAboutCompany(), BorderLayout.CENTER);
			panelAboutCompany.add(getPanelNorthAbout(), BorderLayout.NORTH);
			panelAboutCompany.add(getPanelSouthAbout(), BorderLayout.SOUTH);
			panelAboutCompany.add(getPanelWestAbout(), BorderLayout.WEST);
			panelAboutCompany.add(getPanelEastAbout(), BorderLayout.EAST);
		}
		return panelAboutCompany;
	}
	private JTextArea getTextAreaAboutCompany() {
		if (textAreaAboutCompany == null) {
			textAreaAboutCompany = new JTextArea();
			textAreaAboutCompany.setEditable(false);
			textAreaAboutCompany.setBorder(new TitledBorder(null, "About company", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textAreaAboutCompany.setBackground(SystemColor.control);
		}
		return textAreaAboutCompany;
	}
	private JPanel getPanelNorthAbout() {
		if (panelNorthAbout == null) {
			panelNorthAbout = new JPanel();
			panelNorthAbout.setPreferredSize(new Dimension(50, 12));
		}
		return panelNorthAbout;
	}
	
	private JPanel getPanelSouthAbout() {
		if (panelSouthAbout == null) {
			panelSouthAbout = new JPanel();
			panelSouthAbout.setPreferredSize(new Dimension(50, 12));
		}
		return panelSouthAbout;
	}
	private JPanel getPanelWestAbout() {
		if (panelWestAbout == null) {
			panelWestAbout = new JPanel();
			panelWestAbout.setPreferredSize(new Dimension(20, 12));
		}
		return panelWestAbout;
	}
	private JPanel getPanelEastAbout() {
		if (panelEastAbout == null) {
			panelEastAbout = new JPanel();
			panelEastAbout.setPreferredSize(new Dimension(20, 12));
		}
		return panelEastAbout;
	}
	private JPanel getPanelContactDetails() {
		if (panelContactDetails == null) {
			panelContactDetails = new JPanel();
			panelContactDetails.setLayout(null);
			panelContactDetails.add(getLblImportantContacts());
			panelContactDetails.add(getLblCompanyName());
			panelContactDetails.add(getLblCountry());
			panelContactDetails.add(getLblCoworkerName());
			panelContactDetails.add(getLblEmail());
			panelContactDetails.add(getLblPhone());
			panelContactDetails.add(getLblCOmpanyNameFilled());
			panelContactDetails.add(getLblCoWorkerNAmeFilled());
			panelContactDetails.add(getLblNekaZemljaCuda());
			panelContactDetails.add(getTextFieldPhone());
			panelContactDetails.add(getTextFieldEmail());
		}
		return panelContactDetails;
	}
	private JPanel getPanelLeftButton() {
		if (panelLeftButton == null) {
			panelLeftButton = new JPanel();
			panelLeftButton.setPreferredSize(new Dimension(250, 100));
			panelLeftButton.setLayout(null);
			panelLeftButton.add(getButton());
		}
		return panelLeftButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Task completed");
			button.setBounds(56, 23, 140, 34);
		}
		return button;
	}
	private JList getListTasks() {
		if (listTasks == null) {
			listTasks = new JList();
		}
		return listTasks;
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
