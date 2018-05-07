package classes.task;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.coworker.CoWorker;
import classes.user.User;

public class TestTasks {
	Tasks tasks;
	Task task;
	CoWorker coWorker;

	@Before
	public void setUp() throws Exception {
		tasks = new Tasks();
		
		coWorker = new CoWorker("Komp", "Srbija", "Kompanija", "Petar", 
				"Petrovic", "pp@gmail.com", "0637822998");
		
		task = new Task("Call the boss", "vlajs16", new GregorianCalendar(), 
				coWorker, "You have to do", false);
		
		
	}

	@After
	public void tearDown() throws Exception {
		tasks = null;
		task = null;
		coWorker = null;
	}
	
	
	@Test
	public void testAddTaskToDo() {
		tasks.AddTaskToDo(task);
		assertEquals(1, tasks.getTasks().size());
		assertEquals(task, tasks.getTasks().get(0));
	}
	
	@Test
	public void testAddTaskToDoDuplicate() {
		tasks.AddTaskToDo(task);
		tasks.AddTaskToDo(task);

		assertEquals(1, tasks.getTasks().size());
		assertEquals(task, tasks.getTasks().get(0));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testAddTaskToDoNull() {
		tasks.AddTaskToDo(null);
	}
	
	@Test
	public void testAddTaskDone() {
		tasks.AddTaskToDo(task);
		tasks.AddTaskDone(task);
		assertEquals(1, tasks.getDoneTasks().size());
		task.setDone(true);
		assertEquals(task, tasks.getDoneTasks().get(0));
	}
	
	@Test
	public void testAddTaskDoneDuplicate() {
		tasks.AddTaskToDo(task);
		tasks.AddTaskDone(task);
		tasks.AddTaskDone(task);

		assertEquals(1, tasks.getDoneTasks().size());
		task.setDone(true);
		assertEquals(task, tasks.getDoneTasks().get(0));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testAddTaskDoneNull() {
		tasks.AddTaskToDo(null);
	}
	
	@Test
	public void testSortTasksByDate() {
		tasks.AddTaskToDo(task);
		
		
		Task task2 = new Task("Call the bosses", "vlajs16", new GregorianCalendar(2017, 2, 3), 
				coWorker, "You have to do", false);
		
		tasks.AddTaskToDo(task2);
		tasks.sortTasksByDate();
		
		assertEquals(2, tasks.getTasks().size());
		assertEquals(task2, tasks.getTasks().get(0));
	}
	
	@Test
	public void testShowTillToday() {
		tasks.AddTaskToDo(task);
		Task task2 = new Task("Call the bosses", "vlajs16", new GregorianCalendar(2019, 2, 3), 
				coWorker, "You have to do", false);
		tasks.AddTaskToDo(task2);
		
		assertEquals(1, tasks.showTillToday(new User("Vladimir", "Belca", "vlajs16", "vlajs16")).size());
		assertEquals(task, tasks.showTillToday(new User("Vladimir", "Belca", "vlajs16", "vlajs16")).get(0));

	}

}
