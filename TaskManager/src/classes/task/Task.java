package classes.task;

import java.util.GregorianCalendar;

import classes.coworker.CoWorker;

public class Task {
	private String taskTitle;
	private GregorianCalendar date;
	private CoWorker coWorker;
	private String description;
	private boolean done;
	
	@Override
	public String toString() {
		return taskTitle;
	}
	
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	public CoWorker getCoWorker() {
		return coWorker;
	}
	public void setCoWorker(CoWorker coWorker) {
		this.coWorker = coWorker;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
