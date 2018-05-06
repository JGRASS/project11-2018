package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import classes.coworker.CoWorker;
import classes.task.Task;
import gui.fonts.Fonts;
import gui.kontroler.GUIKontroler;

import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList list;
	private JLabel lblTaskName;
	private JLabel lblCompany;
	private JScrollPane scrollPane;
	private JTextArea textAreaDescription;
	private JLabel lblDoneTasks;
	private JLabel lblTaskTitleFilled;
	private JLabel lblCompanyFilled;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/icons/history.png")));

		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		setResizable(false);
		showDone();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getList());
			panel.add(getLblTaskName());
			panel.add(getLblCompany());
			panel.add(getScrollPane());
			panel.add(getLblDoneTasks());
			panel.add(getLblTaskTitleFilled());
			panel.add(getLblCompanyFilled());
		}
		return panel;
	}

	private JList getList() {
		if (list == null) {
			list = new JList();
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					showTaskDetails();
				}
			});
			list.setBackground(SystemColor.text);
			list.setFont(Fonts.candaraNormal);
			list.setBounds(28, 48, 203, 257);
		}
		return list;
	}


	private JLabel getLblTaskName() {
		if (lblTaskName == null) {
			lblTaskName = new JLabel("Task title:");
			lblTaskName.setFont(new Font("Candara", Font.PLAIN, 15));
			lblTaskName.setBounds(271, 51, 85, 14);
		}
		return lblTaskName;
	}

	private JLabel getLblCompany() {
		if (lblCompany == null) {
			lblCompany = new JLabel("Company:");
			lblCompany.setFont(new Font("Candara", Font.PLAIN, 15));
			lblCompany.setBounds(271, 88, 111, 14);
		}
		return lblCompany;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(261, 123, 283, 182);
			scrollPane.setViewportView(getTextAreaDescription());
		}
		return scrollPane;
	}

	private JTextArea getTextAreaDescription() {
		if (textAreaDescription == null) {
			textAreaDescription = new JTextArea();
			textAreaDescription.setBackground(SystemColor.control);
			textAreaDescription.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Description", TitledBorder.LEFT, TitledBorder.TOP, new Font("Candara", Font.PLAIN, 15),
					new Color(0, 0, 0)));
		}
		return textAreaDescription;
	}

	private JLabel getLblDoneTasks() {
		if (lblDoneTasks == null) {
			lblDoneTasks = new JLabel("Done tasks:");
			lblDoneTasks.setFont(new Font("Candara", Font.PLAIN, 16));
			lblDoneTasks.setBounds(28, 22, 97, 14);
		}
		return lblDoneTasks;
	}

	private JLabel getLblTaskTitleFilled() {
		if (lblTaskTitleFilled == null) {
			lblTaskTitleFilled = new JLabel("");
			lblTaskTitleFilled.setBounds(350, 51, 210, 14);
		}
		return lblTaskTitleFilled;
	}

	private JLabel getLblCompanyFilled() {
		if (lblCompanyFilled == null) {
			lblCompanyFilled = new JLabel("");
			lblCompanyFilled.setBounds(350, 88, 210, 14);
		}
		return lblCompanyFilled;
	}
	
	public void showDone() {
		list.setListData(GUIKontroler.showDoneTasks().toArray());
	}
	
	private void showTaskDetails() {
		Task task = (Task)list.getSelectedValue();
		if (task!=null) {
			lblCompanyFilled.setText(task.getCoWorker().getCompanyName());
			lblTaskTitleFilled.setText(task.getTaskTitle());
			textAreaDescription.setText(task.getDescription());
		}
	}
}
