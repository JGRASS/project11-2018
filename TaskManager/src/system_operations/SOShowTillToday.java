package system_operations;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import classes.task.Task;
import classes.user.User;

public class SOShowTillToday {

	/**
	 * Prikaz svih zadataka koji treba da se odrade zakljucno sa danasnjim danom
	 * @param tasks svi zadaci
	 * @return n zadaci koji treba da se izvrse
	 */
	public static ArrayList<Task> execute(ArrayList<Task> tasks, User user) {
		ArrayList<Task> n = new ArrayList<Task>();
		for (int i = 0; i < tasks.size(); i++) 
			if (!tasks.get(i).getDate().after(new GregorianCalendar()))
				if (tasks.get(i).getUsername().equals(user.getUsername()))
					n.add(tasks.get(i));

		return n;
	}

}
