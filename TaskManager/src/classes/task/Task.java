package classes.task;

import java.io.Serializable;
import java.util.GregorianCalendar;

import classes.coworker.CoWorker;

public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3523333824926124267L;
	private int id;
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
		if (taskTitle.equals(null))
			throw new RuntimeException("Task title is null");
		if (taskTitle.isEmpty())
			throw new RuntimeException("Task title is empty string");
		if (taskTitle.length() < 8)
			throw new RuntimeException("Task title is too short");
		this.taskTitle = taskTitle;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		if (date.equals(null))
			throw new RuntimeException("Date is null");
		if (date.before(new GregorianCalendar()))
			throw new RuntimeException("You cannot schedule a task in the past");
		this.date = date;
	}

	public CoWorker getCoWorker() {
		return coWorker;
	}

	public void setCoWorker(CoWorker coWorker) {
		if (coWorker.equals(null))
			throw new RuntimeException("CoWorker is null");
		this.coWorker = coWorker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description.equals(null))
			throw new RuntimeException("Description is null");
		if (description.isEmpty())
			throw new RuntimeException("Description is empty string");
		if (description.length() < 10)
			throw new RuntimeException("Description is too short");
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
