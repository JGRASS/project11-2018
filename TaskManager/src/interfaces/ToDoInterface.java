package interfaces;

import classes.task.Task;

public interface ToDoInterface {
	
	public void LoadTasksFromFile();
	
	public void LoadTasksFromJson();
	
	public void DeleteTaskFromList(Task task);
	
	public void SaveListOfTasks();
	
	public void DeleteFromJson(Task task);
}
