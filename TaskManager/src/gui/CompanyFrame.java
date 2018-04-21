package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.UIManager;

public class CompanyFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblName;
	private JTextField textFieldName;
	private JLabel lblAddress;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNumber;
	private JLabel lblPhone;
	private Object textAreaCompanyInfo;
	private JTextArea getTextAreaCompanyInfo;
	private JRadioButton rdbtnAddMoreDetails;
	private JButton btnCancel;
	private JButton btnAdd;

	private AddContactFrame acf;

	/**
	 * Create the frame.
	 */
	public CompanyFrame(AddContactFrame acf) {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exit1();
			}
		});
		setTitle("Company ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 493, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ADD NEW CO-WORKER COMPANY", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		
		this.acf = acf;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblName());
			panel.add(getTextFieldName());
			panel.add(getLblAddress());
			panel.add(getTextFieldAddress());
			panel.add(getTextFieldPhoneNumber());
			panel.add(getLblPhone());
			panel.add(getGetTextAreaCompanyInfo());
			panel.add(getRdbtnAddMoreDetails());
			panel.add(getBtnCancel());
			panel.add(getBtnAdd());
		}
		return panel;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setBounds(38, 89, 56, 16);
		}
		return lblName;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setBounds(106, 86, 116, 22);
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setBounds(38, 118, 56, 16);
		}
		return lblAddress;
	}
	private JTextField getTextFieldAddress() {
		if (textFieldAddress == null) {
			textFieldAddress = new JTextField();
			textFieldAddress.setBounds(106, 115, 116, 22);
			textFieldAddress.setColumns(10);
		}
		return textFieldAddress;
	}
	private JTextField getTextFieldPhoneNumber() {
		if (textFieldPhoneNumber == null) {
			textFieldPhoneNumber = new JTextField();
			textFieldPhoneNumber.setBounds(106, 144, 116, 22);
			textFieldPhoneNumber.setColumns(10);
		}
		return textFieldPhoneNumber;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone:");
			lblPhone.setBounds(38, 147, 56, 16);
		}
		return lblPhone;
	}

	private JTextArea getGetTextAreaCompanyInfo() {
		if (getTextAreaCompanyInfo == null) {
			getTextAreaCompanyInfo = new JTextArea();
			getTextAreaCompanyInfo.setToolTipText("To edit this field, you need to select Radio button.");
			getTextAreaCompanyInfo.setEditable(false);
			//getTextAreaCompanyInfo.setBackground(SystemColor.menu);
			getTextAreaCompanyInfo.setBackground(SystemColor.GRAY);
			getTextAreaCompanyInfo.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "more details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getTextAreaCompanyInfo.setBounds(245, 47, 206, 119);
		}
		return getTextAreaCompanyInfo;
	}
	private JRadioButton getRdbtnAddMoreDetails() {
		if (rdbtnAddMoreDetails == null) {
			rdbtnAddMoreDetails = new JRadioButton("Add more details");
			rdbtnAddMoreDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnAddMoreDetails.isSelected()) {
						getGetTextAreaCompanyInfo().setEditable(true);
						getTextAreaCompanyInfo.setBackground(SystemColor.menu);
					}else {
						getGetTextAreaCompanyInfo().setEditable(false);
						getTextAreaCompanyInfo.setBackground(SystemColor.GRAY);
					}
				}
			});
			rdbtnAddMoreDetails.setBounds(245, 21, 127, 25);
		}
		return rdbtnAddMoreDetails;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					exit1();
				}
			});
			btnCancel.setBounds(233, 190, 97, 25);
		}
		return btnCancel;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setBounds(342, 190, 97, 25);
		}
		return btnAdd;
	}
	
	private void exit1() {
		int opcija = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION)
			dispose();
	}
}

