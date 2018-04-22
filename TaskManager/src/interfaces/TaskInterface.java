package interfaces;

import classes.task.Task;

public interface TaskInterface {

	public void LoadTasks(String file1, String file2);
	
	public void AddTaskToDo(Task task);
	
	public void AddTaskDone(Task task);
	
	public void saveTasks(String file1, String file2);
	
}
