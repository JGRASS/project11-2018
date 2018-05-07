package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyleConstants.FontConstants;

import classes.coworker.CoWorker;
import classes.task.Task;
import classes.task.Tasks;
import classes.user.User;
import gui.colors.Colors;
import gui.fonts.Fonts;
import gui.kontroler.GUIKontroler;

import javax.swing.JList;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6968116630508984077L;
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
	private JButton btnTaskCompleted;
	private JList listTasks;
	
	private Tasks tasks;
	private User user;


	/**
	 * Create the frame.
	 */
	public MainFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exitLogOut();
			}
		});
		setFont(new Font("Candara", Font.PLAIN, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/icons/taskDone2.png")));
		setTitle("TaskManager");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		int width = (int) tk.getScreenSize().getWidth();
//		int height = (int) tk.getScreenSize().getHeight();
//		setBounds(100, 100, 1080, 1500);
//		this.setSize(JFrame.MAXIMIZED_VERT, JFrame.MAXIMIZED_HORIZ);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Colors.gray);
		contentPane.setFont(new Font("Candara", Font.PLAIN, 13));
		contentPane.setBorder(new EmptyBorder(10, 20, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelWest(), BorderLayout.WEST);
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getPanelNorth(), BorderLayout.NORTH);
		contentPane.add(getPanelCenter(), BorderLayout.CENTER);
		contentPane.add(getPanelSouth(), BorderLayout.SOUTH);
		
		mainFrame = this;
		showTasks();
//		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);		
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
			mnFile.setFont(new Font("Candara", Font.PLAIN, 15));
			mnFile.add(getMntmLogOut());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnEdit() {
		if (mnEdit == null) {
			mnEdit = new JMenu("Edit");
			mnEdit.setFont(new Font("Candara", Font.PLAIN, 15));
			mnEdit.add(getMntmNewTask());
			mnEdit.add(getMntmNewContact());
		}
		return mnEdit;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setFont(new Font("Candara", Font.PLAIN, 15));
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmLogOut() {
		if (mntmLogOut == null) {
			mntmLogOut = new JMenuItem("Log out");
			mntmLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					exitLogOut();
					
				}
			});
			mntmLogOut.setFont(new Font("Candara", Font.PLAIN, 15));
			mntmLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		}
		return mntmLogOut;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
			mntmExit.setFont(new Font("Candara", Font.PLAIN, 15));
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					exitLogOut();
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
					GUIKontroler.searchContacts();
					
				}
			});
			mntmNewContact.setFont(new Font("Candara", Font.PLAIN, 15));
			mntmNewContact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
			//mntmNewContact.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		}
		return mntmNewContact;
	}
	private JMenuItem getMntmNewTask() {
		if (mntmNewTask == null) {
			mntmNewTask = new JMenuItem("New task");
			mntmNewTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.addingNewTask();
				}
			});
			mntmNewTask.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
			mntmNewTask.setFont(new Font("Candara", Font.PLAIN, 15));
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
			mntmAbout.setFont(new Font("Candara", Font.PLAIN, 15));
			mntmAbout.setIcon(null);
		}
		return mntmAbout;
	}
	private JLabel getLblYourTasksFor() {
		if (lblYourTasksFor == null) {
			lblYourTasksFor = new JLabel("Your tasks for today:");
			lblYourTasksFor.setForeground(Color.WHITE);
			lblYourTasksFor.setFont(new Font("Candara", Font.PLAIN, 16));
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
			lblHello = new JLabel("");
			lblHello.setBackground(Colors.gray);
			lblHello.setFont(Fonts.candaraTitle1);
			lblHello = new JLabel("Hello");
			lblHello.setForeground(Colors.blue);
		}
		return lblHello;
	}
	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setBackground(Colors.gray);
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
			panelEast.setBackground(Colors.gray);
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
			btnAddTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.addingNewTask();
				}
			});
			btnAddTask.setFont(new Font("Candara", Font.PLAIN, 15));
			btnAddTask.setBackground(Colors.green);
			btnAddTask.setBounds(10, 37, 140, 34);
		}
		return btnAddTask;
	}
	private JButton getBtnContacts() {
		if (btnContacts == null) {
			btnContacts = new JButton("Contacts");
			btnContacts.setFont(new Font("Candara", Font.PLAIN, 15));
			btnContacts.setBackground(Colors.green);
			btnContacts.setBounds(10, 102, 140, 34);
			btnContacts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.searchContacts();
					
				}
			});
		}
		return btnContacts;
	}
	private JButton getBtnHistory() {
		if (btnHistory == null) {
			btnHistory = new JButton("History");
			btnHistory.setFont(new Font("Candara", Font.PLAIN, 15));
			btnHistory.setBackground(Colors.green);
			btnHistory.setBounds(10, 167, 140, 34);
			btnHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.searchHistory();
					
				}

			});
		}
		return btnHistory;
	}
	private JButton getBtnLogOut() {
		if (btnLogOut == null) {
			btnLogOut = new JButton("Log out");
			btnLogOut.setFont(new Font("Candara", Font.PLAIN, 15));
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					exitLogOut();

				}

			});
			btnLogOut.setBackground(Colors.green);
			btnLogOut.setBounds(10, 21, 140,34);
		}
		return btnLogOut;
	}
	private JLabel getLblCUrrentDate() {
		if (lblCUrrentDate == null) {
			lblCUrrentDate = new JLabel("");
			lblCUrrentDate.setFont(Fonts.candaraTitle1);
			lblCUrrentDate.setBackground(Colors.gray);
			lblCUrrentDate.setForeground(Colors.blue);
			
			Calendar date = new GregorianCalendar();
			int day = date.get(Calendar.DAY_OF_MONTH);
			int month = date.get(Calendar.MONTH) + 1;
			int year = date.get(Calendar.YEAR);
			lblCUrrentDate.setText("Date:  "+day+"."+month+"."+year+".   ");
		}
		return lblCUrrentDate;
	}
	private JPanel getPanelNorth() {
		if (panelNorth == null) {
			panelNorth = new JPanel();
			panelNorth.setBackground(Colors.gray);
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
			panelCenter.setBackground(Colors.gray);
			panelCenter.setLayout(new BorderLayout(1000,10));
			panelCenter.add(getLblTasksDetails(), BorderLayout.NORTH);
			panelCenter.add(getScrollPaneCenter());
		}
		return panelCenter;
	}
	private JLabel getLblTasksDetails() {
		if (lblTasksDetails == null) {
			lblTasksDetails = new JLabel("  Task's details:");
			lblTasksDetails.setForeground(Color.WHITE);
			lblTasksDetails.setBackground(Colors.gray);
			lblTasksDetails.setFont(new Font("Candara", Font.PLAIN, 16));
		}
		return lblTasksDetails;
	}
	private JScrollPane getScrollPaneCenter() {
		if (scrollPaneCenter == null) {
			scrollPaneCenter = new JScrollPane();
			scrollPaneCenter.setBackground(Colors.gray);
			scrollPaneCenter.setViewportView(getSplitPane());
		}
		return scrollPaneCenter;
	}
	private JPanel getPanelSouth() {
		if (panelSouth == null) {
			panelSouth = new JPanel();
			panelSouth.setBackground(Colors.gray);
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
//			splitPane.setBackground(Colors.gray);
			
			splitPane.setDividerSize(13);
			splitPane.setBorder(new EmptyBorder(15, 15, 15, 15));
			splitPane.setLeftComponent(getScrollPaneLeft());
			splitPane.setRightComponent(getScrollPaneRight());
			splitPane.setDividerLocation(415);
			splitPane.setBackground(Colors.gray);
			
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
			separator.setBackground(Colors.gray);
			separator.setPreferredSize(new Dimension(0, 15));
			separator.setAlignmentX(Component.LEFT_ALIGNMENT);
			separator.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		}
		return separator;
	}
	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			panelButton.setBackground(Colors.gray);
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
			lblImportantContacts.setForeground(Color.WHITE);
			lblImportantContacts.setFont(new Font("Candara", Font.PLAIN, 16));
			lblImportantContacts.setBounds(10, 33, 113, 14);
		}
		return lblImportantContacts;
	}
	private JLabel getLblCompanyName() {
		if (lblCompanyName == null) {
			lblCompanyName = new JLabel("Company name:");
			lblCompanyName.setForeground(Color.WHITE);
			lblCompanyName.setFont(new Font("Candara", Font.PLAIN, 14));
			lblCompanyName.setBounds(24, 116, 99, 14);
		}
		return lblCompanyName;
	}
	private JLabel getLblCoworkerName() {
		if (lblCoworkerName == null) {
			lblCoworkerName = new JLabel("Co-worker name:");
			lblCoworkerName.setForeground(Color.WHITE);
			lblCoworkerName.setFont(new Font("Candara", Font.PLAIN, 15));
			lblCoworkerName.setBounds(24, 172, 113, 14);
		}
		return lblCoworkerName;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Candara", Font.PLAIN, 15));
			lblEmail.setBounds(24, 226, 46, 14);
		}
		return lblEmail;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone:");
			lblPhone.setForeground(Color.WHITE);
			lblPhone.setFont(new Font("Candara", Font.PLAIN, 15));
			lblPhone.setBounds(24, 284, 46, 14);
		}
		return lblPhone;
	}
	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel("Country:");
			lblCountry.setForeground(Color.WHITE);
			lblCountry.setFont(new Font("Candara", Font.PLAIN, 15));
			lblCountry.setBounds(24, 344, 99, 14);
		}
		return lblCountry;
	}
	private JLabel getLblCOmpanyNameFilled() {
		if (lblCOmpanyNameFilled == null) {
			lblCOmpanyNameFilled = new JLabel("");
			lblCOmpanyNameFilled.setForeground(Color.WHITE);
			lblCOmpanyNameFilled.setFont(new Font("Candara", Font.PLAIN, 15));
			lblCOmpanyNameFilled.setBounds(163, 116, 225, 14);
		}
		return lblCOmpanyNameFilled;
	}
	private JLabel getLblCoWorkerNAmeFilled() {
		if (lblCoWorkerNAmeFilled == null) {
			lblCoWorkerNAmeFilled = new JLabel("");
			lblCoWorkerNAmeFilled.setForeground(Color.WHITE);
			lblCoWorkerNAmeFilled.setFont(new Font("Candara", Font.PLAIN, 15));
			lblCoWorkerNAmeFilled.setBounds(163, 172, 225, 14);
		}
		return lblCoWorkerNAmeFilled;
	}
	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setBackground(Colors.lightGray);
			textFieldEmail.setForeground(Color.WHITE);
			textFieldEmail.setFont(new Font("Candara", Font.PLAIN, 15));
			textFieldEmail.setBounds(163, 223, 225, 20);
			textFieldEmail.setEditable(false);
			textFieldEmail.setBorder(null);
			textFieldEmail.setColumns(10);
			textFieldEmail.setBorder(null);
			textFieldEmail.setBackground(Colors.gray);
		}
		return textFieldEmail;
	}
	private JTextField getTextFieldPhone() {
		if (textFieldPhone == null) {
			textFieldPhone = new JTextField();
			textFieldPhone.setBackground(Colors.lightGray);
			textFieldPhone.setForeground(Color.WHITE);
			textFieldPhone.setFont(new Font("Candara", Font.PLAIN, 15));
			textFieldPhone.setBounds(163, 281, 225, 20);
			textFieldPhone.setEditable(false);
			textFieldPhone.setColumns(10);
			textFieldPhone.setBorder(null);
			textFieldPhone.setBackground(Colors.gray);
		}
		return textFieldPhone;
	}
	private JLabel getLblNekaZemljaCuda() {
		if (lblNekaZemljaCuda == null) {
			lblNekaZemljaCuda = new JLabel("");
			lblNekaZemljaCuda.setForeground(Color.WHITE);
			lblNekaZemljaCuda.setFont(new Font("Canadra", Font.PLAIN, 15));
			
			lblNekaZemljaCuda.setBounds(163, 344, 225, 14);
		}
		return lblNekaZemljaCuda;
	}
	private JPanel getPanelDetailsOfTask() {
		if (panelDetailsOfTask == null) {
			panelDetailsOfTask = new JPanel();
			panelDetailsOfTask.setForeground(Color.WHITE);
			panelDetailsOfTask.setLayout(new BorderLayout(0, 0));
			panelDetailsOfTask.add(getPanelTaskDescription(), BorderLayout.NORTH);
			panelDetailsOfTask.add(getTextAreaComments(), BorderLayout.CENTER);
		}
		return panelDetailsOfTask;
	}
	private JPanel getPanelTaskDescription() {
		if (panelTaskDescription == null) {
			panelTaskDescription = new JPanel();
			panelTaskDescription.setPreferredSize(new Dimension(150, 460));
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
			textAreaTaskDescription.setForeground(Color.WHITE);
			textAreaTaskDescription.setBackground(Colors.gray);
			textAreaTaskDescription.setFont(new Font("Candara", Font.PLAIN, 15));
			textAreaTaskDescription.setEditable(false);
			
		}
		return textAreaTaskDescription;
	}
	private JTextArea getTextAreaComments() {
		if (textAreaComments == null) {
			textAreaComments = new JTextArea();
			textAreaComments.setForeground(Color.WHITE);
			textAreaComments.setBackground(Colors.lightGray);
			textAreaComments.setFont(new Font("Candara", Font.PLAIN, 15));
			textAreaComments.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color)Color.WHITE),"Comments",
					TitledBorder.LEADING, TitledBorder.TOP, Fonts.candaraNormal, Color.WHITE));
		}
		return textAreaComments;
	}
	private JPanel getPanelPomocni() {
		if (panelPomocni == null) {
			panelPomocni = new JPanel();
			panelPomocni.setBackground(Colors.gray);
			panelPomocni.setLayout(new BorderLayout(0, 0));
			panelPomocni.add(getListTasks(), BorderLayout.CENTER);
		}
		return panelPomocni;
	}
	private JPanel getPanelAboutCompany() {
		if (panelAboutCompany == null) {
			panelAboutCompany = new JPanel();
			panelAboutCompany.setPreferredSize(new Dimension(100, 270));
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
			textAreaAboutCompany.setText("\r\n");
			textAreaAboutCompany.setEditable(false);
			textAreaAboutCompany.setBackground(Colors.gray);
			textAreaAboutCompany.setForeground(Color.WHITE);
			textAreaAboutCompany.setFont(new Font("Candara", Font.PLAIN, 15));
			textAreaAboutCompany.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color)Color.WHITE), "About company",
			TitledBorder.LEADING, TitledBorder.TOP, Fonts.candaraNormal, Color.WHITE));
		}
		return textAreaAboutCompany;
	}
	private JPanel getPanelNorthAbout() {
		if (panelNorthAbout == null) {
			panelNorthAbout = new JPanel();
			panelNorthAbout.setBackground(Colors.gray);
			panelNorthAbout.setPreferredSize(new Dimension(50, 12));
		}
		return panelNorthAbout;
	}
	
	private JPanel getPanelSouthAbout() {
		if (panelSouthAbout == null) {
			panelSouthAbout = new JPanel();
			panelSouthAbout.setBackground(Colors.gray);
			panelSouthAbout.setPreferredSize(new Dimension(50, 12));
		}
		return panelSouthAbout;
	}
	private JPanel getPanelWestAbout() {
		if (panelWestAbout == null) {
			panelWestAbout = new JPanel();
			panelWestAbout.setBackground(Colors.gray);
			panelWestAbout.setPreferredSize(new Dimension(20, 12));
		}
		return panelWestAbout;
	}
	private JPanel getPanelEastAbout() {
		if (panelEastAbout == null) {
			panelEastAbout = new JPanel();
			panelEastAbout.setBackground(Colors.gray);
			panelEastAbout.setPreferredSize(new Dimension(20, 12));
		}
		return panelEastAbout;
	}
	private JPanel getPanelContactDetails() {
		if (panelContactDetails == null) {
			panelContactDetails = new JPanel();
			panelContactDetails.setBackground(Colors.gray);
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
			panelLeftButton.setBackground(Colors.gray);
			panelLeftButton.setPreferredSize(new Dimension(250, 100));
			panelLeftButton.setLayout(null);
			panelLeftButton.add(getBtnTaskCompleted());
		}
		return panelLeftButton;
	}
	private JButton getBtnTaskCompleted() {
		if (btnTaskCompleted == null) {
			btnTaskCompleted = new JButton("Task completed");
			btnTaskCompleted.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Task task = (Task) listTasks.getSelectedValue();
					if(task!= null) {
						task.setComment(textAreaComments.getText());
						clearWindow();
						GUIKontroler.taskCompleted(task);
						GUIKontroler.refreshTasks();
					}
				}
			});
			btnTaskCompleted.setFont(new Font("Candara", Font.PLAIN, 15));
			btnTaskCompleted.setBackground(Colors.green);
			btnTaskCompleted.setBounds(56, 23, 140, 34);
		}
		return btnTaskCompleted;
	}
	private JList getListTasks() {
		if (listTasks == null) {
			listTasks = new JList();
			listTasks.setBackground(Colors.lightGray);
			listTasks.setForeground(Color.WHITE);
			listTasks.setFont(new Font("Candara", Font.PLAIN, 15));
			listTasks.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					showTaskDetails();
				}
			});
		}
		return listTasks;
	}
	
	private void exit() {
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION)
			dispose();
	}
	private void exitLogOut() {
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logging out", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			GUIKontroler.loggingIn();
			
		}
	}
	
	public void setHello(User user) {
		lblHello.setText("Hello, "+ user.toString());
		lblHello.setFont(Fonts.candaraTitle1);
	}
	public void showTasks() {
		listTasks.setListData(GUIKontroler.showAllTasksToDo().toArray());
	}
	
	private void showTaskDetails() {
		Task task = (Task) listTasks.getSelectedValue();
		if(task != null) {
			CoWorker worker = task.getCoWorker();
		
		lblCOmpanyNameFilled.setText(worker.getCompanyName());
		lblCoWorkerNAmeFilled.setText(worker.getName()+" "+worker.getSurname());
		textFieldEmail.setText(worker.getEmail());
		textFieldPhone.setText(worker.getPhone());
		textAreaTaskDescription.setText(task.getDescription());
		textAreaAboutCompany.setText(worker.getAboutCompany());
		lblNekaZemljaCuda.setText(worker.getCountry());
		}
	}
	
	private void clearWindow() {
		lblCOmpanyNameFilled.setText("");
		lblCoWorkerNAmeFilled.setText("");
		textFieldEmail.setText("");
		textFieldPhone.setText("");
		textAreaTaskDescription.setText("");
		textAreaAboutCompany.setText("");
		lblNekaZemljaCuda.setText("");
	}
	
	
}
