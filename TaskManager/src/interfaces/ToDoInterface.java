package interfaces;

import classes.task.Task;

public interface ToDoInterface {
	
	public void LoadTasks();
	
	public void AddTaskToDo(Task task);
	
	public void AddTaskDone(Task task);
	
	public void SaveAllTasks();
	
	public void separateTasks();
}
