package system_operations;

import java.util.ArrayList;

import classes.task.Task;

/**
 * Cekiranje zadataka koji su izvrseni 
 * @param task zadatak koji je odradjen
 * @param tasks lista zadataka 
 * @return tasks azuriranu listu zadataka
 */
public class SOAddTaskDone {
	public static void execute(Task task, ArrayList<Task> tasks) {
		if(tasks.contains(task)) {
			tasks.remove(task);
			task.setDone(true);
		}
	}
}
