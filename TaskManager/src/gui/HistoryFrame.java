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
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JList;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblSelectDate;
	private JLabel lblSelectContact;
	private JComboBox comboBoxDate;
	private JComboBox comboBoxContacts;
	private JRadioButton rdbtnDate;
	private JRadioButton rdbtnContact;
	private JLabel lblSearchBy;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblDetails;
	private JList list;
		

	/**
	 * Create the frame.
	 */
	public HistoryFrame() {
		setTitle("History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 379);
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
			panel.add(getComboBoxDate());
			panel.add(getComboBoxContacts());
			panel.add(getRdbtnContact());
			panel.add(getRdbtnDate());
			panel.add(getLblSearchBy());
			panel.add(getLblDetails());
			panel.add(getList());
		}
		return panel;
	}
	private JLabel getLblSelectDate() {
		if (lblSelectDate == null) {
			lblSelectDate = new JLabel("Select date:");
			lblSelectDate.setBounds(252, 40, 108, 16);
		}
		return lblSelectDate;
	}
	private JLabel getLblSelectContact() {
		if (lblSelectContact == null) {
			lblSelectContact = new JLabel("Select contact:");
			lblSelectContact.setBounds(252, 63, 108, 16);
		}
		return lblSelectContact;
	}
	private JComboBox getComboBoxDate() {
		if (comboBoxDate == null) {
			comboBoxDate = new JComboBox();
			comboBoxDate.setVisible(false);
			comboBoxDate.setBounds(361, 36, 141, 19);
		}
		return comboBoxDate;
	}
	private JComboBox getComboBoxContacts() {
		if (comboBoxContacts == null) {
			comboBoxContacts = new JComboBox();
			comboBoxContacts.setVisible(false);
			comboBoxContacts.setBounds(361, 60, 141, 22);
		}
		return comboBoxContacts;
	}
	private JRadioButton getRdbtnDate() {
		if (rdbtnDate == null) {
			rdbtnDate = new JRadioButton("Date");
			rdbtnDate.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if(rdbtnDate.isSelected()) {
						comboBoxDate.setVisible(true);
						comboBoxDate.setEditable(true);
						comboBoxContacts.setVisible(false);
						lblSelectContact.setForeground(Color.GRAY);
					}else {
						comboBoxDate.setVisible(false);
						comboBoxContacts.setVisible(false);
						lblSelectContact.setForeground(Color.BLACK);
					}
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
			rdbtnContact.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					if(rdbtnContact.isSelected()) {
						comboBoxDate.setVisible(false);
						comboBoxContacts.setVisible(true);
						comboBoxDate.setEditable(false);
						comboBoxContacts.setEditable(true);
						lblSelectDate.setForeground(Color.GRAY);
					}else {
						comboBoxDate.setVisible(false);
						comboBoxContacts.setVisible(false);
						lblSelectDate.setForeground(Color.BLACK);
					}
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
			lblSearchBy.setBounds(22, 13, 75, 16);
		}
		return lblSearchBy;
	}
	private JLabel getLblDetails() {
		if (lblDetails == null) {
			lblDetails = new JLabel("Details:");
			lblDetails.setBounds(32, 110, 56, 16);
		}
		return lblDetails;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBackground(Color.LIGHT_GRAY);
			list.setBounds(42, 129, 484, 168);
		}
		return list;
	}
}
