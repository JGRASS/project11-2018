package classes.task;

import java.util.ArrayList;

import interfaces.ToDoInterface;

public class TasksToDo implements ToDoInterface{
	/**
	 * All tasks opened from data base
	 */
	private ArrayList<Task> allTasks = new ArrayList<Task>();
	/**
	 * Tasks that user have completed before
	 */
	private ArrayList<Task> doneTasks = new ArrayList<Task>();
	/**
	 * Tasks user have to do
	 */
	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	
	public ArrayList<Task> getDoneTasks() {
		return doneTasks;
	}
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	
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
	public void SaveAllTasks() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void separateTasks() {
		// TODO Auto-generated method stub
		
	}
	
	
}
