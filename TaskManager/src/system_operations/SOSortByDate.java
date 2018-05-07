package system_operations;

import java.util.ArrayList;
import java.util.Collections;

import classes.task.Task;

public class SOSortByDate {
	
	/**
	 * Sortiranje zadataka po datumu
	 * @param tasks zadaci koji treba da se odrade
	 * @return tasks sortirani zadaci po datumu
	 */
	public static ArrayList<Task> execute(ArrayList<Task> tasks){
		Collections.sort(tasks);
		return tasks;
	}
	
}
