package classes.task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import interfaces.TaskInterface;
import system_operations.SOAddTaskDone;
import system_operations.SOAddTaskToDo;
import system_operations.SOLoadTasks;
import system_operations.SOSaveTasks;
import system_operations.SOSortByDate;

public class Tasks implements TaskInterface {
	/**
	 * Tasks that user have completed before
	 */
	private ArrayList<Task> doneTasks = new ArrayList<Task>();
	/**
	 * Tasks user have to do
	 */
	private ArrayList<Task> tasks = new ArrayList<Task>();

	@Override
	public void AddTaskToDo(Task task) {
		tasks = SOAddTaskToDo.execute(task, tasks);
	}

	@Override
	public void AddTaskDone(Task task) {
		if(SOAddTaskDone.execute(task, tasks) != null) {
			tasks = SOAddTaskDone.execute(task, tasks);
			doneTasks = SOAddTaskToDo.execute(task, doneTasks);
		}
	}

	@Override
	public void LoadTasks(String file1, String file2) {
		tasks = SOLoadTasks.execute(file1);
		doneTasks = SOLoadTasks.execute(file2);
	}

	@Override
	public void saveTasks(String file1, String file2) {
		SOSaveTasks.execute(file1, tasks);
		SOSaveTasks.execute(file2, doneTasks);
	}
	

	@Override
	public void sortTasksByDate() {
		tasks = SOSortByDate.execute(tasks);
		doneTasks = SOSortByDate.execute(doneTasks);
	}

	@Override
	public ArrayList<Task> showTillToday() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Task> getDoneTasks() {
		return doneTasks;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}


}
