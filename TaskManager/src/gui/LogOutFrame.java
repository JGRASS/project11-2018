package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class LogOutFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblHaveANice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOutFrame frame = new LogOutFrame();
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
	public LogOutFrame() {
		setTitle("Good bye!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thanks for logging out.", TitledBorder.TRAILING, TitledBorder.ABOVE_BOTTOM, null, new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getLblHaveANice());
		}
		return panel;
	}
	private JLabel getLblHaveANice() {
		if (lblHaveANice == null) {
			lblHaveANice = new JLabel("Have a nice day!");
			lblHaveANice.setForeground(Color.GRAY);
			lblHaveANice.setHorizontalAlignment(SwingConstants.CENTER);
			lblHaveANice.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return lblHaveANice;
	}
}
