package classes.task;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	

}
