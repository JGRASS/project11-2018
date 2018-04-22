package interfaces;

import classes.task.Task;

public interface TaskInterface {

	public void LoadTasks();
	
	public void AddTaskToDo(Task task);
	
	public void AddTaskDone(Task task);
	
	public void SaveAllToDoTasks();
	
	public void SaveAllDoneTasks();
	
	public void serializeTasks();
}
