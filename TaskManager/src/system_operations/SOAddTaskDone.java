package system_operations;

import java.util.ArrayList;

import classes.task.Task;

public class SOAddTaskDone {
	public static ArrayList<Task> execute(Task task, ArrayList<Task> tasks) {
		if(tasks.contains(task)) {
			tasks.remove(task);
			task.setDone(true);
			return tasks;
		}
		return null;
	}
}
