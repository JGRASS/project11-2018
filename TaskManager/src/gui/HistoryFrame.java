package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import classes.coworker.CoWorker;
import gui.fonts.Fonts;

import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSelectDate;
	private JLabel lblSelectContact;
	private JRadioButton rdbtnDate;
	private JRadioButton rdbtnContact;
	private JLabel lblSearchBy;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblDetails;
	private JList list;
	private JSpinner spinnerDate;
	private JComboBox comboBoxContacts;
		

	/**
	 * Create the frame.
	 */
	public HistoryFrame() {
		setTitle("History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 379);
		setFont(Fonts.candaraNormal);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblSelectDate());
			panel.add(getLblSelectContact());
			panel.add(getRdbtnContact());
			panel.add(getRdbtnDate());
			panel.add(getLblSearchBy());
			panel.add(getLblDetails());
			panel.add(getList());
			panel.add(getSpinnerDate());
			panel.add(getComboBoxContacts());
		}
		return panel;
	}
	private JLabel getLblSelectDate() {
		if (lblSelectDate == null) {
			lblSelectDate = new JLabel("Select date:");
			lblSelectDate.setFont(Fonts.candaraNormal);
			lblSelectDate.setBounds(252, 40, 108, 16);
		}
		return lblSelectDate;
	}
	private JLabel getLblSelectContact() {
		if (lblSelectContact == null) {
			lblSelectContact = new JLabel("Select contact:");
			lblSelectContact.setFont(Fonts.candaraNormal);
			lblSelectContact.setBounds(252, 63, 108, 16);
		}
		return lblSelectContact;
	}
	private JRadioButton getRdbtnDate() {
		if (rdbtnDate == null) {
			rdbtnDate = new JRadioButton("Date");
			rdbtnDate.setSelected(true);
			rdbtnDate.setFont(Fonts.candaraNormal);
			rdbtnDate.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					showDate();
				}
			});
			
			buttonGroup.add(rdbtnDate);
			rdbtnDate.setBounds(22, 36, 127, 25);
		}
		return rdbtnDate;
	}
	private JRadioButton getRdbtnContact() {
		if (rdbtnContact == null) {
			rdbtnContact = new JRadioButton("Contact");
			rdbtnContact.setFont(Fonts.candaraNormal);
			rdbtnContact.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					showContact();
				}

			});
			buttonGroup.add(rdbtnContact);
			rdbtnContact.setBounds(22, 59, 127, 25);
		}
		return rdbtnContact;
	}
	private JLabel getLblSearchBy() {
		if (lblSearchBy == null) {
			lblSearchBy = new JLabel("Search by:");
			lblSearchBy.setFont(Fonts.candaraNormal);
			lblSearchBy.setBounds(22, 13, 75, 16);
		}
		return lblSearchBy;
	}
	private JLabel getLblDetails() {
		if (lblDetails == null) {
			lblDetails = new JLabel("Details:");
			lblDetails.setFont(Fonts.candaraNormal);
			lblDetails.setBounds(32, 110, 56, 16);
		}
		return lblDetails;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBackground(Color.LIGHT_GRAY);
			list.setFont(Fonts.candaraNormal);
			list.setBounds(42, 129, 484, 168);
		}
		return list;
	}
	private void showDate() {
		if(rdbtnDate.isSelected()) {
			spinnerDate.setVisible(true);
			
			comboBoxContacts.setVisible(false);
			lblSelectContact.setForeground(Color.GRAY);
		}else {
			spinnerDate.setVisible(false);
			comboBoxContacts.setVisible(false);
			lblSelectContact.setForeground(Color.BLACK);
		}
	}
	private void showContact() {
		if(rdbtnContact.isSelected()) {
			spinnerDate.setVisible(false);
			comboBoxContacts.setVisible(true);
			
			comboBoxContacts.setEditable(true);
			lblSelectDate.setForeground(Color.GRAY);
		}else {
			spinnerDate.setVisible(false);
			comboBoxContacts.setVisible(false);
			lblSelectDate.setForeground(Color.BLACK);
		}
	}
	private JSpinner getSpinnerDate() {
		if (spinnerDate == null) {
			spinnerDate = new JSpinner();
			spinnerDate.setModel(new SpinnerDateModel(new Date(1524639600000L), new Date(1524607200000L), null, Calendar.DAY_OF_YEAR));
			spinnerDate.setBounds(358, 38, 127, 16);
		}
		return spinnerDate;
	}
	private JComboBox getComboBoxContacts() {
		if (comboBoxContacts == null) {
			comboBoxContacts = new JComboBox();
			comboBoxContacts.setBounds(358, 58, 127, 16);
		}
		return comboBoxContacts;
	}
	public void showContacts(ArrayList<CoWorker> contacts) {
		comboBoxContacts.addItem(contacts.toArray());
	}
}
