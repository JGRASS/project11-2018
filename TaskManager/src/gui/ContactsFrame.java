package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import classes.coworker.CoWorker;
import gui.colors.Colors;
import gui.fonts.Fonts;
import gui.kontroler.GUIKontroler;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;



public class ContactsFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAddNewContact;
	private JList list;
	private JButton btnCancel;
	
	private ContactsFrame cntf;
	private JLabel lblContactList;
	private JScrollPane scrollPane;
	private JLabel lblCompany;
	private JLabel lblCompanyFillled;
	private JLabel lblCoworker;
	private JLabel lblCoWorkerFilled;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JLabel lblPhoneNumber;


	/**
	 * Create the frame.
	 */
	public ContactsFrame() {
		
		setResizable(false);
		setTitle("Contacts");
		setFont(Fonts.candaraNormal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ContactsFrame.class.getResource("/icons/Contacts.png")));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		
		showContacts();
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Colors.gray);
			panel.setLayout(null);
			panel.add(getBtnAddNewContact());
			panel.add(getBtnCancel());
			panel.add(getLblContactList());
			panel.add(getScrollPane());
			panel.add(getLblCompany());
			panel.add(getLblCompanyFillled());
			panel.add(getLblCoworker());
			panel.add(getLblCoWorkerFilled());
			panel.add(getLblEmail());
			panel.add(getTextFieldEmail());
			panel.add(getTextFieldPhone());
			panel.add(getLblPhoneNumber());
		}
		return panel;
	}
	private JButton getBtnAddNewContact() {
		if (btnAddNewContact == null) {
			btnAddNewContact = new JButton("Add new contact");
			btnAddNewContact.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.addingContact();
				}
			});
			btnAddNewContact.setBackground(Colors.green);
			btnAddNewContact.setFont(Fonts.candaraNormal);
			btnAddNewContact.setBounds(56, 343, 146, 25);
		}
		return btnAddNewContact;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					CoWorker co = (CoWorker)list.getSelectedValue();
					lblCompanyFillled.setText(co.getCompanyName());
					lblCoWorkerFilled.setText(co.getName()+" "+co.getSurname());
					textFieldEmail.setText(co.getEmail());
					textFieldPhone.setText(co.getPhone());
				}
			});
			list.setForeground(Color.WHITE);
			list.setBackground(Colors.lightGray);
			list.setFont(Fonts.candaraNormal);
			list.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		}
		return list;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancel.setBackground(Colors.green);
			btnCancel.setFont(Fonts.candaraNormal);
			btnCancel.setBounds(259, 343, 146, 25);
		}
		return btnCancel;
	}

	private JLabel getLblContactList() {
		if (lblContactList == null) {
			lblContactList = new JLabel("List of contacts:");
			lblContactList.setForeground(Colors.blue);
			lblContactList.setHorizontalAlignment(SwingConstants.LEFT);
			lblContactList.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblContactList.setFont(Fonts.candaraNormal);
			lblContactList.setBounds(12, 19, 118, 16);
		}
		return lblContactList;
	}
	
	public void showContacts() {
		list.setListData(GUIKontroler.showAllContacts().toArray());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBounds(12, 46, 221, 274);
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JLabel getLblCompany() {
		if (lblCompany == null) {
			lblCompany = new JLabel("Company:");
			lblCompany.setBounds(243, 53, 64, 14);
			lblCompany.setForeground(Color.WHITE);
			lblCompany.setFont(Fonts.candaraNormal);
		}
		return lblCompany;
	}
	private JLabel getLblCompanyFillled() {
		if (lblCompanyFillled == null) {
			lblCompanyFillled = new JLabel("");
			lblCompanyFillled.setBounds(243, 78, 201, 14);
			lblCompanyFillled.setForeground(Color.WHITE);
			lblCompanyFillled.setFont(Fonts.candaraNormal);
		}
		return lblCompanyFillled;
	}
	private JLabel getLblCoworker() {
		if (lblCoworker == null) {
			lblCoworker = new JLabel("CoWorker:");
			lblCoworker.setBounds(243, 123, 82, 14);
			lblCoworker.setForeground(Color.WHITE);
			lblCoworker.setFont(Fonts.candaraNormal);
		}
		return lblCoworker;
	}
	private JLabel getLblCoWorkerFilled() {
		if (lblCoWorkerFilled == null) {
			lblCoWorkerFilled = new JLabel("");
			lblCoWorkerFilled.setBounds(243, 149, 201, 14);
			lblCoWorkerFilled.setForeground(Color.WHITE);
			lblCoWorkerFilled.setFont(Fonts.candaraNormal);
		}
		return lblCoWorkerFilled;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(243, 191, 64, 14);
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(Fonts.candaraNormal);
		}
		return lblEmail;
	}
	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setBorder(null);
			textFieldEmail.setEditable(false);
			textFieldEmail.setAutoscrolls(false);
			textFieldEmail.setBounds(243, 216, 201, 20);
			textFieldEmail.setColumns(10);
			textFieldEmail.setBackground(Colors.gray);
			textFieldEmail.setFont(Fonts.candaraNormal);
			textFieldEmail.setForeground(Color.WHITE);
		}
		return textFieldEmail;
	}
	private JTextField getTextFieldPhone() {
		if (textFieldPhone == null) {
			textFieldPhone = new JTextField();
			textFieldPhone.setBorder(null);
			textFieldPhone.setEditable(false);
			textFieldPhone.setFont(new Font("Candara", Font.PLAIN, 15));
			textFieldPhone.setColumns(10);
			textFieldPhone.setBackground(new Color(60, 68, 79));
			textFieldPhone.setBounds(243, 288, 201, 20);
			textFieldPhone.setForeground(Color.WHITE);
		}
		return textFieldPhone;
	}
	private JLabel getLblPhoneNumber() {
		if (lblPhoneNumber == null) {
			lblPhoneNumber = new JLabel("Phone number:");
			lblPhoneNumber.setForeground(Color.WHITE);
			lblPhoneNumber.setFont(new Font("Candara", Font.PLAIN, 15));
			lblPhoneNumber.setBounds(243, 263, 118, 14);
		}
		return lblPhoneNumber;
	}
}
