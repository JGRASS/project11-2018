package system_operations;

import java.util.ArrayList;

import classes.task.Task;

public class SOAddTaskToDo {
	
	
	/**
	 * Dodavanje novog zadatka
	 * @param task novi zadatak koji dodajemo
	 * @param tasks trenutna lista zadataka
	 * @return tasks azurirana lista zadataka
	 */
	public static void execute(Task task, ArrayList<Task> tasks) {
		if(task == null)
			throw new RuntimeException("Task is null");
		if (!tasks.contains(task))
			tasks.add(task);
	}
	
}
