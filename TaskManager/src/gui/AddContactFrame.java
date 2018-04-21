package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddContactFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblName;
	private JTextField textFieldName;
	private JLabel lblSurname;
	private JTextField textFieldSurname;
	private JLabel lblPhoneNumber;
	private JTextField textFieldPhoneNumber;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JLabel lblCompanyInfo;
	private JTextArea textAreaCompanyInfo;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JButton btnCancel;
	
	private AddContactFrame acf;
	private ContactsFrame cntf;



	/**
	 * Create the frame.
	 */
	public AddContactFrame(ContactsFrame cntf) {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exit1();
			}
		});
		setVisible(true);
		setTitle("Add contact");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 504, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		
		this.cntf = cntf;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contact details", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getLblName());
			panel.add(getTextFieldName());
			panel.add(getLblSurname());
			panel.add(getTextFieldSurname());
			panel.add(getLblPhoneNumber());
			panel.add(getTextFieldPhoneNumber());
			panel.add(getLblEmail());
			panel.add(getTextFieldEmail());
			panel.add(getLblCompanyInfo());
			panel.add(getTextAreaCompanyInfo());
			panel.add(getComboBox());
			panel.add(getBtnAdd());
			panel.add(getBtnCancel());
		}
		return panel;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setBounds(32, 22, 56, 16);
		}
		return lblName;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setBounds(156, 16, 116, 22);
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}
	private JLabel getLblSurname() {
		if (lblSurname == null) {
			lblSurname = new JLabel("Surname:");
			lblSurname.setBounds(32, 54, 72, 16);
		}
		return lblSurname;
	}
	private JTextField getTextFieldSurname() {
		if (textFieldSurname == null) {
			textFieldSurname = new JTextField();
			textFieldSurname.setBounds(156, 48, 116, 22);
			textFieldSurname.setColumns(10);
		}
		return textFieldSurname;
	}
	private JLabel getLblPhoneNumber() {
		if (lblPhoneNumber == null) {
			lblPhoneNumber = new JLabel("Phone number:");
			lblPhoneNumber.setBounds(32, 89, 108, 16);
		}
		return lblPhoneNumber;
	}
	private JTextField getTextFieldPhoneNumber() {
		if (textFieldPhoneNumber == null) {
			textFieldPhoneNumber = new JTextField();
			textFieldPhoneNumber.setBounds(156, 83, 116, 22);
			textFieldPhoneNumber.setColumns(10);
		}
		return textFieldPhoneNumber;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(32, 124, 56, 16);
		}
		return lblEmail;
	}
	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setBounds(156, 118, 116, 22);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}
	private JLabel getLblCompanyInfo() {
		if (lblCompanyInfo == null) {
			lblCompanyInfo = new JLabel("Company info:");
			lblCompanyInfo.setBounds(32, 185, 108, 16);
		}
		return lblCompanyInfo;
	}
	private JTextArea getTextAreaCompanyInfo() {
		if (textAreaCompanyInfo == null) {
			textAreaCompanyInfo = new JTextArea();
			textAreaCompanyInfo.setBackground(SystemColor.menu);
			textAreaCompanyInfo.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "more details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textAreaCompanyInfo.setBounds(156, 185, 245, 51);
		}
		return textAreaCompanyInfo;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem().equals("add new Company")) {
						CompanyFrame cf = new CompanyFrame(acf);
						cf.setVisible(true);
					}
				}
			});
			comboBox.setToolTipText("Please select Company here.");
			comboBox.setEditable(true);
			comboBox.setBounds(32, 203, 108, 22);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Company1", "Company2", "Company3", "...", "add new Company"}));
			
			
		}
		return comboBox;
	}
	private void exit1() {
		int opcija = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION)
			dispose();
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setBounds(325, 45, 97, 25);
		}
		return btnAdd;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					exit1();
				}
			});
			btnCancel.setBounds(325, 85, 97, 25);
		}
		return btnCancel;
	}
}
