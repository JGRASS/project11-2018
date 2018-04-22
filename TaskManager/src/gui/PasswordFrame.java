package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class PasswordFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUsername;
	private JTextField textFieldUsername;
	private JLabel lblPassword;
	private JButton btnLogIn;
	private JButton btnExit;
	private JSeparator separator;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordFrame frame = new PasswordFrame();
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
	public PasswordFrame() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exit();
			}
		});
		setResizable(false);
		setVisible(true);
		setTitle("Login");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 459, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		contentPane.add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 453, 270);
			panel.setLayout(null);
			panel.add(getLblUsername());
			panel.add(getTextFieldUsername());
			panel.add(getLblPassword());
			panel.add(getBtnLogIn());
			panel.add(getBtnExit());
			panel.add(getSeparator());
			panel.add(getPasswordField());
		}
		return panel;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username: ");
			lblUsername.setBounds(96, 71, 78, 21);
		}
		return lblUsername;
	}
	private JTextField getTextFieldUsername() {
		if (textFieldUsername == null) {
			textFieldUsername = new JTextField();
			textFieldUsername.setToolTipText("Please, type your username here.");
			textFieldUsername.setBounds(186, 70, 175, 22);
			textFieldUsername.setColumns(10);
		}
		return textFieldUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(96, 126, 78, 16);
		}
		return lblPassword;
	}
	private void goToMainFrame() {
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}
	
	private JButton getBtnLogIn() {
		if (btnLogIn == null) {
			btnLogIn = new JButton("Log in");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					goToMainFrame();
				}
			});
			btnLogIn.setBounds(271, 214, 90, 25);
		}
		return btnLogIn;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					exit();
				}
			});
			btnExit.setBounds(96, 214, 97, 25);
		}
		return btnExit;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(64, 178, 326, 28);
		}
		return separator;
	}
	
	private void exit() {
		int opcija = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setToolTipText("Please, type your password here.");
			passwordField.setBounds(186, 123, 176, 21);
		}
		return passwordField;
	}
}

