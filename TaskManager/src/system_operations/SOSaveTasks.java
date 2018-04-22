package system_operations;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import classes.task.Task;

public class SOSaveTasks {
	
	public static void execute(String file, ArrayList<Task> tasks) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(tasks);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
