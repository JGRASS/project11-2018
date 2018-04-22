package system_operations;

import java.util.ArrayList;
import java.util.Collections;

import classes.task.Task;

public class SOSortByDate {
	
	public static ArrayList<Task> execute(ArrayList<Task> tasks){
		Collections.sort(tasks);
		return tasks;
	}
	
}
