package classes.task;

import java.util.ArrayList;

import interfaces.TaskInterface;

public class Tasks implements TaskInterface{
	/**
	 * Tasks that user have completed before
	 */
	private ArrayList<Task> doneTasks = new ArrayList<Task>();
	/**
	 * Tasks user have to do
	 */
	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	
	@Override
	public void LoadTasks() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void AddTaskToDo(Task task) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void AddTaskDone(Task task) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void SaveAllToDoTasks() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void SaveAllDoneTasks() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void serializeTasks() {
		// TODO Auto-generated method stub
		
	}
	
	
	public ArrayList<Task> getDoneTasks() {
		return doneTasks;
	}
	public ArrayList<Task> getTasks() {
		return tasks;
	}

}
