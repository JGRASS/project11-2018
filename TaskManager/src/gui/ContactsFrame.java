package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import gui.colors.Colors;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ContactsFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAddNewContact;
	private JList list;
	private JButton btnCancel;
	
	private ContactsFrame cntf;
	private JLabel lblContactList;

	private MainFrame mf;
	

	/**
	 * Create the frame.
	 */
	public ContactsFrame(MainFrame mf) {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exit1();
			}
		});
		setTitle("Contacts");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		
		this.mf = mf;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnAddNewContact());
			panel.add(getList());
			panel.add(getBtnCancel());
			panel.add(getLblContactList());
		}
		return panel;
	}
	private JButton getBtnAddNewContact() {
		if (btnAddNewContact == null) {
			btnAddNewContact = new JButton("Add new contact");
			btnAddNewContact.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddContactFrame acf = new AddContactFrame(cntf);
					acf.setVisible(true);
				}
			});
			btnAddNewContact.setBackground(Colors.lightGreen);
			btnAddNewContact.setBounds(12, 250, 146, 25);
		}
		return btnAddNewContact;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(170, 13, 240, 300);
			list.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		}
		return list;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					exit1();
				}
			});
			btnCancel.setBackground(Colors.lightGreen);
			btnCancel.setBounds(12, 288, 146, 25);
		}
		return btnCancel;
	}
	private void exit1() {
		int opcija = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION)
			dispose();
}
	private JLabel getLblContactList() {
		if (lblContactList == null) {
			lblContactList = new JLabel("List of contacts:");
			lblContactList.setHorizontalAlignment(SwingConstants.RIGHT);
			lblContactList.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblContactList.setBounds(40, 18, 118, 16);
		}
		return lblContactList;
	}
}
