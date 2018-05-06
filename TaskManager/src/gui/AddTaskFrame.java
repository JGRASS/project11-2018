package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import classes.coworker.CoWorker;
import classes.coworker.Contacts;
import gui.colors.Colors;
import gui.fonts.Fonts;
import gui.kontroler.GUIKontroler;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.time.DayOfWeek;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;

public class AddTaskFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCoworker;
	private JLabel lblDate;
	private JTextArea textAreaDescription;
	private JTextField textFieldTitle;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox comboBoxCoWorker;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JSpinner spinner;

	

	/**
	 * Create the frame.
	 */
	public AddTaskFrame() {
		setTitle("Add task");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Colors.gray);		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTitle());
		contentPane.add(getLblCoworker());
		contentPane.add(getLblDate());
		contentPane.add(getTextFieldTitle());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnCancel());
		contentPane.add(getComboBoxCoWorker());
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
		contentPane.add(getSpinner());
		setResizable(false);
		
		showContacts();
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("Title:");
			lblTitle.setFont(Fonts.candaraNormal);
			lblTitle.setBounds(44, 31, 46, 14);
		}
		return lblTitle;
	}
	private JLabel getLblCoworker() {
		if (lblCoworker == null) {
			lblCoworker = new JLabel("CoWorker:");
			lblCoworker.setFont(Fonts.candaraNormal);
			lblCoworker.setBounds(44, 137, 88, 14);
		}
		return lblCoworker;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date:");
			lblDate.setFont(Fonts.candaraNormal);
			lblDate.setBounds(44, 83, 46, 14);
		}
		return lblDate;
	}
	private JTextArea getTextAreaDescription() {
		if (textAreaDescription == null) {
			textAreaDescription = new JTextArea();
			textAreaDescription.setBackground(Colors.gray);
			textAreaDescription.setFont(Fonts.candaraNormal);
			textAreaDescription.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color)Colors.lightGray), "Description",
					TitledBorder.LEADING, TitledBorder.TOP, Fonts.candaraNormal, Colors.lightGray));
		}
		return textAreaDescription;
	}
	private JTextField getTextFieldTitle() {
		if (textFieldTitle == null) {
			textFieldTitle = new JTextField();
			textFieldTitle.setBackground(Colors.lightGray);
			textFieldTitle.setFont(Fonts.candaraNormal);
			textFieldTitle.setBounds(134, 28, 168, 20);
			textFieldTitle.setColumns(10);
		}
		return textFieldTitle;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = new SimpleDateFormat("yyyy/MM/dd").format(spinner.getValue());
					GUIKontroler.saveTask(textFieldTitle.getText(), (CoWorker)comboBoxCoWorker.getSelectedItem(), searchByDate(s), textAreaDescription.getText());
					GUIKontroler.refreshTasks();
					dispose();
				}
			});
			btnAdd.setFont(Fonts.candaraNormal);
			btnAdd.setBackground(Colors.green);
			btnAdd.setBounds(362, 222, 140, 23);
		}
		return btnAdd;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancel.setFont(Fonts.candaraNormal);
			btnCancel.setBackground(Colors.green);
			btnCancel.setBounds(362, 272, 140, 23);
		}
		return btnCancel;
	}
	private JComboBox getComboBoxCoWorker() {
		if (comboBoxCoWorker == null) {
			comboBoxCoWorker = new JComboBox();
			comboBoxCoWorker.setBackground(Colors.lightGray);
			comboBoxCoWorker.setToolTipText("Choose CoWorker");
			comboBoxCoWorker.setFont(Fonts.candaraNormal);
			comboBoxCoWorker.setBounds(134, 133, 168, 22);
		}
		return comboBoxCoWorker;
	}
	
	public void showContacts() {
		for(int i = 0; i < GUIKontroler.showAllContacts().size(); i++)
		comboBoxCoWorker.addItem(GUIKontroler.showAllContacts().get(i));
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New CoWorker");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.addingContactTask();
				}
			});
			btnNewButton.setFont(Fonts.candaraNormal);
			btnNewButton.setBackground(Colors.green);
			btnNewButton.setBounds(362, 133, 140, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBounds(30, 190, 295, 140);
			scrollPane.setViewportView(getTextAreaDescription());
		}
		return scrollPane;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					String format = new SimpleDateFormat("yyyy/MM/dd").format(spinner.getValue());
//					System.out.println(format);
//					searchByDate(format);
				}
			});
			spinner.setModel(new SpinnerDateModel(new Date(1525590000000L), new Date(1525590000000L), null, Calendar.DAY_OF_YEAR));
//			spinner.setForeground(Colors.lightGray);
			spinner.setFont(Fonts.candaraNormal);
//			spinner.setBackground(Colors.lightGray);
			spinner.setBounds(134, 76, 168, 20);
//			SpinnerNumberModel nummodel = new SpinnerNumberModel(5, 0, 10, 1); 
//			JSpinner numspinner = new JSpinner(nummodel); 
//			numspinner.getEditor().getComponent(0).setBackground(Color.green); 
			}
		return spinner;
	}
	
	public GregorianCalendar searchByDate(String s) {
		int br = s.lastIndexOf("/");
		int dd = Integer.parseInt(s.substring(br + 1,s.length()));
		
		int mm = Integer.parseInt(s.substring(6, 7));
		int yy = Integer.parseInt(s.substring(0, 4)); 
		//System.out.println("Datum: "+ dd+"."+mm+"."+yy+".");
		return new GregorianCalendar(yy, mm, dd);

	}
}
