package classes.task;

import java.util.ArrayList;

import classes.user.User;
import interfaces.TaskInterface;
import system_operations.SOAddTaskDone;
import system_operations.SOAddTaskToDo;
import system_operations.SOLoadTasks;
import system_operations.SOSaveTasks;
import system_operations.SOShowTillToday;
import system_operations.SOSortByDate;

/**
 * Klasa koja predstavlja zadatke
 * @author vlajs16
 *
 */
public class Tasks implements TaskInterface {
	/**
	 * Lista izvrsenih zadataka
	 */
	private ArrayList<Task> doneTasks = new ArrayList<Task>();
	/**
	 * Lista zadataka koji treba da se izvrse
	 */
	private ArrayList<Task> tasks = new ArrayList<Task>();

	/**
	 * Dodavanje novog zadatka u listu
	 * Sortiranje liste prema datumu
	 * @param task novi zadatak
	 */
	@Override
	public void AddTaskToDo(Task task) {
		SOAddTaskToDo.execute(task, tasks);
		sortTasksByDate();
	}

	/**
	 * Dodavanje izvrsenog zadatka u listu izvrsenih zadataka
	 * Azuriranje liste zadataka koji treba da se odrade
	 * Sortiranje liste zadataka prema datumu
	 * @param task zadatak koji je odradjen
	 */
	@Override
	public void AddTaskDone(Task task) {
		if(tasks.contains(task)) {
			SOAddTaskDone.execute(task, tasks);
			SOAddTaskToDo.execute(task, doneTasks);
			sortTasksByDate();
		}
		
	}

	/**
	 * Ucitavanje zadataka iz datoteka
	 * Sortiranje zadataka po datumu
	 * @param file1 datoteka sa zadacima koji treba da se izvrse
	 * @param file2 datoteka sa zadacima koji su odradjeni
	 */
	@Override
	public void LoadTasks(String file1, String file2) {
		tasks = SOLoadTasks.execute(file1);
		doneTasks = SOLoadTasks.execute(file2);
		sortTasksByDate();
	}

	/**
	 * Sortiranje zadataka po datumu
	 * Cuvanje zadataka u datoteke
	 * @param file1 datoteka sa zadacima koji treba da se izvrse
	 * @param file2 datoteka sa zadacima koji su odradjeni
	 */
	@Override
	public void saveTasks(String file1, String file2) {
		sortTasksByDate();
		SOSaveTasks.execute(file1, tasks);
		SOSaveTasks.execute(file2, doneTasks);
	}
	
	/**
	 * Sortiranje zadataka koji treba da se odrade po datumu
	 * Sortiranje odradjenih zadataka po datumu
	 */
	@Override
	public void sortTasksByDate() {
		tasks = SOSortByDate.execute(tasks);
		doneTasks = SOSortByDate.execute(doneTasks);
	}

	/**
	 * Prikaz zadataka koji treba da se odrade zakljucno sa danasnjim danom
	 * @return listu zadataka za izvrsavanje
	 */
	@Override
	public ArrayList<Task> showTillToday(User user) {
		return SOShowTillToday.execute(tasks, user);
	}

	/**
	 * Vraca listu odradjenih zadataka
	 * @return doneTasks lista odradjenih zadataka
	 */
	public ArrayList<Task> getDoneTasks() {
		return doneTasks;
	}

	/**
	 * Vraca listu zadataka koji treba da se odrade
	 * @return tasks lista zadataka
	 */
	public ArrayList<Task> getTasks() {
		return tasks;
	}


}
