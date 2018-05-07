package system_operations;

import java.util.ArrayList;

import classes.task.Task;

/**
 * Cekiranje zadataka koji su izvrseni 
 * @param task zadatak koji je odradjen
 * @param tasks lista zadataka 
 * @throws java.lang.RuntimeException ako je vrednost unetog zadatka null
 */
public class SOAddTaskDone {
	public static void execute(Task task, ArrayList<Task> tasks) {
		if(task == null)
			throw new RuntimeException("Task is null");
		if(tasks.contains(task)) {
			tasks.remove(task);
			task.setDone(true);
		}
	}
}
