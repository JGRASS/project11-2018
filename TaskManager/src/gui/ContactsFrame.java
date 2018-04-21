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
	private JButton btnNewButton;
	
	private ContactsFrame cntf;
	private JLabel lblContactList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactsFrame frame = new ContactsFrame();
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
	public ContactsFrame() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exit();
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
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnAddNewContact());
			panel.add(getList());
			panel.add(getBtnNewButton());
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cancel");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					exit();
				}
			});
			btnNewButton.setBounds(12, 288, 146, 25);
		}
		return btnNewButton;
	}
	private void exit() {
		int opcija = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
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
