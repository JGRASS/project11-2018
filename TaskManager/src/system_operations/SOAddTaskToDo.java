package system_operations;

import java.util.ArrayList;

import classes.task.Task;

public class SOAddTaskToDo {
	
	public static ArrayList<Task> execute(Task task, ArrayList<Task> tasks) {
		if (!tasks.contains(task))
			tasks.add(task);
		return tasks;
	}
	
}
