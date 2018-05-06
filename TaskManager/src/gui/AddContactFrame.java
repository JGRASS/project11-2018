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

import gui.colors.Colors;
import gui.fonts.Fonts;
import gui.kontroler.GUIKontroler;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

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
	private JButton btnAdd;
	private JButton btnCancel;

	private JLabel lblCompanyName;
	private JLabel lblCountry;
	private JTextField textFieldCompanyName;
	private JTextField textFieldCountry;
	private JSeparator separator;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public AddContactFrame() {
		setResizable(false);

		setVisible(true);
		setTitle("Add contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Colors.gray);
			
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
			panel.add(getBtnAdd());
			panel.add(getBtnCancel());
			panel.add(getLblCompanyName());
			panel.add(getLblCountry());
			panel.add(getTextFieldCompanyName());
			panel.add(getTextFieldCountry());
			panel.add(getSeparator());
			panel.add(getScrollPane());
		}
		return panel;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setFont(Fonts.candaraNormal);
			lblName.setBounds(32, 22, 56, 16);
		}
		return lblName;
	}

	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setBackground(Colors.lightGray);
			textFieldName.setBounds(156, 16, 116, 22);
			textFieldName.setFont(Fonts.candaraNormal);
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}

	private JLabel getLblSurname() {
		if (lblSurname == null) {
			lblSurname = new JLabel("Surname:");
			lblSurname.setFont(Fonts.candaraNormal);
			lblSurname.setBounds(32, 54, 72, 16);
		}
		return lblSurname;
	}

	private JTextField getTextFieldSurname() {
		if (textFieldSurname == null) {
			textFieldSurname = new JTextField();
			textFieldSurname.setBackground(Colors.lightGray);
			textFieldSurname.setBounds(156, 48, 116, 22);
			textFieldSurname.setFont(Fonts.candaraNormal);
			textFieldSurname.setColumns(10);
		}
		return textFieldSurname;
	}

	private JLabel getLblPhoneNumber() {
		if (lblPhoneNumber == null) {
			lblPhoneNumber = new JLabel("Phone number:");
			lblPhoneNumber.setFont(Fonts.candaraNormal);
			lblPhoneNumber.setBounds(32, 89, 108, 16);
		}
		return lblPhoneNumber;
	}

	private JTextField getTextFieldPhoneNumber() {
		if (textFieldPhoneNumber == null) {
			textFieldPhoneNumber = new JTextField();
			textFieldPhoneNumber.setBackground(Colors.lightGray);
			textFieldPhoneNumber.setBounds(156, 83, 116, 22);
			textFieldPhoneNumber.setFont(Fonts.candaraNormal);
			textFieldPhoneNumber.setColumns(10);
		}
		return textFieldPhoneNumber;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("E-mail:");
			lblEmail.setFont(Fonts.candaraNormal);
			lblEmail.setBounds(32, 124, 56, 16);
		}
		return lblEmail;
	}

	private JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setBackground(Colors.lightGray);
			textFieldEmail.setBounds(156, 118, 116, 22);
			textFieldEmail.setFont(Fonts.candaraNormal);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}

	private JLabel getLblCompanyInfo() {
		if (lblCompanyInfo == null) {
			lblCompanyInfo = new JLabel("Company info:");
			lblCompanyInfo.setFont(Fonts.candaraNormal);
			lblCompanyInfo.setBounds(32, 182, 108, 16);
		}
		return lblCompanyInfo;
	}

	private JTextArea getTextAreaCompanyInfo() {
		if (textAreaCompanyInfo == null) {
			textAreaCompanyInfo = new JTextArea();
			textAreaCompanyInfo.setBackground(Colors.gray);
			textAreaCompanyInfo.setBorder(
					new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color)Colors.lightGray), "Company details:",
							TitledBorder.LEADING, TitledBorder.TOP, Fonts.candaraNormal, Colors.lightGray));
			textAreaCompanyInfo.setFont(Fonts.candaraNormal);
		}
		return textAreaCompanyInfo;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			
						try {
							GUIKontroler.saveContact(textFieldName.getText(), textFieldSurname.getText(),
									textFieldPhoneNumber.getText(), textFieldEmail.getText(),
									textFieldCompanyName.getText(), textFieldCountry.getText(),
									textAreaCompanyInfo.getText());
							GUIKontroler.refreshContacts();
							dispose();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					
				}
			});
			btnAdd.setBackground(Colors.green);
			btnAdd.setFont(Fonts.candaraNormal);
			btnAdd.setBounds(325, 45, 97, 25);
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
			btnCancel.setBackground(Colors.green);
			btnCancel.setFont(Fonts.candaraNormal);
			btnCancel.setBounds(325, 85, 97, 25);
		}
		return btnCancel;
	}

	private JLabel getLblCompanyName() {
		if (lblCompanyName == null) {
			lblCompanyName = new JLabel("Name:");
			lblCompanyName.setFont(Fonts.candaraNormal);
			lblCompanyName.setBounds(32, 211, 56, 16);
		}
		return lblCompanyName;
	}

	private JLabel getLblCountry() {
		if (lblCountry == null) {
			lblCountry = new JLabel("Country:");
			lblCountry.setFont(Fonts.candaraNormal);
			lblCountry.setBounds(32, 239, 56, 16);
		}
		return lblCountry;
	}

	private JTextField getTextFieldCompanyName() {
		if (textFieldCompanyName == null) {
			textFieldCompanyName = new JTextField();
			textFieldCompanyName.setBackground(Colors.lightGray);
			textFieldCompanyName.setFont(Fonts.candaraNormal);
			textFieldCompanyName.setBounds(156, 208, 116, 22);
			textFieldCompanyName.setColumns(10);
		}
		return textFieldCompanyName;
	}

	private JTextField getTextFieldCountry() {
		if (textFieldCountry == null) {
			textFieldCountry = new JTextField();
			textFieldCountry.setBackground(Colors.lightGray);
			textFieldCountry.setFont(Fonts.candaraNormal);
			textFieldCountry.setBounds(156, 236, 116, 22);
			textFieldCountry.setColumns(10);
		}
		return textFieldCountry;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Colors.blue);
			separator.setBounds(32, 164, 390, 16);
		}
		return separator;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBounds(24, 274, 408, 99);
			scrollPane.setViewportView(getTextAreaCompanyInfo());
		}
		return scrollPane;
	}
}
