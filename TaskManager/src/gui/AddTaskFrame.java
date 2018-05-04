package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
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
			textAreaDescription.setLineWrap(true);
			textAreaDescription.setFont(Fonts.candaraNormal);
			textAreaDescription.setBorder(new TitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.TOP, Fonts.candaraNormal, new Color(0, 128, 0)));
		}
		return textAreaDescription;
	}
	private JTextField getTextFieldTitle() {
		if (textFieldTitle == null) {
			textFieldTitle = new JTextField();
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
//					GUIKontroler.saveTask(textFieldTitle.getText(), (CoWorker)comboBoxCoWorker.getSelectedItem(), (GregorianCalendar)spinner.getValue(), textAreaDescription.getText());
					/*SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyy");
					Calendar date = (Calendar)spinner.getValue();
					System.out.println(sf.format(date.getTime()));*/
				}
			});
			btnAdd.setFont(Fonts.candaraNormal);
			btnAdd.setBackground(Colors.lightGreen);
			btnAdd.setBounds(362, 222, 123, 23);
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
			btnCancel.setBackground(Colors.lightGreen);
			btnCancel.setBounds(362, 272, 123, 23);
		}
		return btnCancel;
	}
	private JComboBox getComboBoxCoWorker() {
		if (comboBoxCoWorker == null) {
			comboBoxCoWorker = new JComboBox();
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
			btnNewButton.setBackground(Colors.lightGreen);
			btnNewButton.setBounds(362, 133, 123, 23);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
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
					System.out.println(format);
					searchByDate(format);
				}
			});
			spinner.setModel(new SpinnerDateModel(new Date(1525417200000L), null, new Date(1525417200000L), Calendar.DAY_OF_MONTH));
			
			spinner.setBounds(134, 76, 168, 20);
			
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
