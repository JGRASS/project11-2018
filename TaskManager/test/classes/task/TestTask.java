package classes.task;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classes.coworker.CoWorker;

public class TestTask {
	Task task;

	@Before
	public void setUp() throws Exception {
		task = new Task();
	}

	@After
	public void tearDown() throws Exception {
		task = null;
	}

	@Test
	public void testSetTaskTitle() {
		String taskTitle = "Call your boss";
		task.setTaskTitle(taskTitle);
		assertEquals(taskTitle, task.getTaskTitle());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetTaskTitleNull() {
		task.setTaskTitle(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetTaskTitleEmptyString() {
		task.setTaskTitle("");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetTaskTitleTooShort() {
		task.setTaskTitle("Title");
	}

	@Test
	public void testSetDate() {
		GregorianCalendar date = new GregorianCalendar(2019, GregorianCalendar.FEBRUARY, 16);
		task.setDate(date);
		assertEquals(date, task.getDate());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDateNull() {
		task.setDate(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDateBefore() {
		GregorianCalendar date = new GregorianCalendar(2017, GregorianCalendar.FEBRUARY, 16);
		task.setDate(date);
	}

	@Test
	public void testDescription() {
		String description = "This is description";
		task.setDescription(description);
		assertEquals(description, task.getDescription());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDescriptionNull() {
		task.setDescription(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDescriptionEmptyString() {
		task.setDescription("");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDescriptionTooShort() {
		task.setDescription("Descript");
	}

	@Test
	public void testDoneTrue() {
		task.setDone(true);
		assertTrue(task.isDone());
	}

	@Test
	public void testDoneFalse() {
		task.setDone(false);
		assertFalse(task.isDone());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetCoWorker() {
		task.setCoWorker(null);
	}

	@Test
	public void testToString() {
		String taskTitle = "Call your boss";
		task.setTaskTitle(taskTitle);
		assertEquals(taskTitle, task.toString());
	}

}
