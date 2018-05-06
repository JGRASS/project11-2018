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
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblTaskName;
	private JLabel lblCompany;
	private JScrollPane scrollPane;
	private JTextArea textAreaDescription;
	private JLabel lblDoneTasks;
	private JLabel lblTaskTitleFilled;
	private JLabel lblCompanyFilled;
	private JRadioButton rdbtnShowDoneTasks;
	private JRadioButton rdbtnAllTasks;
	private JButton btnCancel;
	private JScrollPane scrollPane_1;
	private JList list;
	
	private ArrayList<Task> tasks;

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
//		showDone();
		tasks = GUIKontroler.showTasksToDo();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblTaskName());
			panel.add(getLblCompany());
			panel.add(getScrollPane());
			panel.add(getLblDoneTasks());
			panel.add(getLblTaskTitleFilled());
			panel.add(getLblCompanyFilled());
			
			panel.add(getBtnCancel());
			panel.add(getScrollPane_1());
			panel.add(getRdbtnShowDoneTasks());
			panel.add(getRdbtnAllTasks());
//			panel.add(getList_1());
		}
		return panel;
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
			scrollPane.setBorder(null);
			scrollPane.setBounds(261, 123, 283, 157);
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
			lblDoneTasks = new JLabel("Tasks:");
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
	
	public void showAllTasks() {
		list.setListData(tasks.toArray());
	}
	private JRadioButton getRdbtnShowDoneTasks() {
		if (rdbtnShowDoneTasks == null) {
			rdbtnShowDoneTasks = new JRadioButton("Done tasks");
			rdbtnShowDoneTasks.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					showDone();
				}
			});
			rdbtnShowDoneTasks.setFont(new Font("Candara", Font.PLAIN, 13));
			rdbtnShowDoneTasks.setSelected(true);
			buttonGroup.add(rdbtnShowDoneTasks);
			rdbtnShowDoneTasks.setBounds(28, 289, 85, 23);
		}
		return rdbtnShowDoneTasks;
	}
	private JRadioButton getRdbtnAllTasks() {
		if (rdbtnAllTasks == null) {
			rdbtnAllTasks = new JRadioButton("Tasks to do");
			rdbtnAllTasks.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					showAllTasks();
				}
			});
			rdbtnAllTasks.setFont(new Font("Candara", Font.PLAIN, 13));
			buttonGroup.add(rdbtnAllTasks);
			rdbtnAllTasks.setBounds(125, 289, 89, 23);
		}
		return rdbtnAllTasks;
	}
	private void clear() {
//		if(list.getComponentCount()!=0)
//			list.removeAll();
//		System.out.println(list.getComponentCount());
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancel.setBounds(455, 296, 89, 23);
		}
		return btnCancel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(28, 51, 186, 229);
			scrollPane_1.setViewportView(getList_1());
		}
		return scrollPane_1;
	}
	private JList getList_1() {
		if (list == null) {
			list = new JList();
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					showTaskDetails();
				}
			});
		}
		return list;
	}
	
	private void showTaskDetails() {
		Task task = (Task)list.getSelectedValue();
		lblCompanyFilled.setText(task.getCoWorker().getCompanyName());
		lblTaskTitleFilled.setText(task.getTaskTitle());
		textAreaDescription.setText(task.getDescription());
	}
}
