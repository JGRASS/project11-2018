package classes.task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import interfaces.TaskInterface;

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
		if (!tasks.contains(task))
			tasks.add(task);
	}

	@Override
	public void AddTaskDone(Task task) {
		if(tasks.contains(task)) {
			tasks.remove(task);
			task.setDone(true);
			doneTasks.add(task);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void LoadTasks(String file1, String file2) {
		try(ObjectInputStream in = 
				new ObjectInputStream(
						new FileInputStream(file1))){
			tasks = (ArrayList<Task>) in.readObject();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try(ObjectInputStream in = 
				new ObjectInputStream(
						new FileInputStream(file2))){
			doneTasks = (ArrayList<Task>) in.readObject();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void saveTasks(String file1, String file2) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file1))) {
			out.writeObject(tasks);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file2))) {
			out.writeObject(doneTasks);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public ArrayList<Task> getDoneTasks() {
		return doneTasks;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

}
