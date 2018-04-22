package system_operations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import classes.task.Task;

public class SOShowTillToday {
	
	public static ArrayList<Task> execute(ArrayList<Task> tasks){
		ArrayList<Task> n = new ArrayList<Task>();
		for(int i = 0; i<tasks.size(); i++) {
			if(!tasks.get(i).getDate().after(new GregorianCalendar()))
				n.add(tasks.get(i));
		}
		return n;
	}
	
}
