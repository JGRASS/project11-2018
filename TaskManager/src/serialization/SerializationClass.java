package serialization;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import classes.task.Task;
import classes.task.Tasks;
import classes.Paths;
//import java.io.File;
//import java.net.URL;
//import java.util.ArrayList;
//
import classes.coworker.CoWorker;
//import classes.coworker.Contacts;
import classes.user.User;
import classes.users.Users;

public class SerializationClass {

	public static String path = "src/Files/contacts.serialized";
	public static String path2 = "src/Files/users.serialized";

	public static void main(String[] args) {
		CoWorker cow1 = new CoWorker("Vanilica company", "Serbia", "A company that makes cookies", "Mirko", "Petrovic",
				"mirko.petrovic@gmail.com", "0638967444");
		CoWorker cow2 = new CoWorker("Next", "Serbia", "A company that makes juice", "Malina", "Gustic",
				"malina.gus@gmail.com", "0638967445");
		CoWorker cow3 = new CoWorker("Pandora", "Denmark", "A company that makes jewellery", "Naktita", "Prelepota",
				"naky.poypoy@gmail.com", "0638967484");
		//
		// Contacts contacts = new Contacts();
		//
		// contacts.addContact(cow1);
		// contacts.addContact(cow2);
		// contacts.addContact(cow3);
		//
		// for(int i = 0; i<contacts.getContacts().size(); i++)
		// System.out.println(contacts.getContacts().get(i));
		//
		//// URL url = SerializationClass.class.getClassLoader().getResource("Files");
		//
		//
		//
		//// contacts.SaveContacts("src/Files/contacts.serialized");
		//
		// contacts.getContacts().clear();
		//
		// contacts.LoadContacts(path);
		//
		// ArrayList<CoWorker> found = contacts.FindContactByName("Milica");
		//
		// for(int i = 0; i<found.size(); i++)
		// System.out.println(found.get(i));

		// System.out.println(url.toString());

		// User u1 = new User("Teodora", "Acimov", "acimovljeva", "acimovljeva97");
		// User u2 = new User("Kristina", "Dekic", "dekana", "dekana8");
		 User u3 = new User("Vladimir", "Belca", "vlajs16", "vlajs16");
		// User u4 = new User("Bojan", "Tomic", "bokica", "bokica69");
		//
		// Users users = new Users();
		// users.addUser(u1);
		// users.addUser(u2);
		// users.addUser(u3);
		// users.addUser(u4);

		// for(int i = 0; i<users.getUsers().size(); i++)
		// System.out.println(users.getUsers().get(i));

		// users.saveUsers(path2);
		// users.getUsers().clear();
		//
		// users.loadUsers(path2);
		//
		// for(int i = 0; i<users.getUsers().size(); i++)
		// System.out.println(users.getUsers().get(i));

		Task t1 = new Task("Call Malina", u3.getUsername(), new GregorianCalendar(2018, GregorianCalendar.APRIL, 12), cow2,
				"Pozovi i poruci sokove", false);
		Task t2 = new Task("Call Vanilica Company", "vlajs16", new GregorianCalendar(2018, GregorianCalendar.APRIL, 20), cow1,
				"Pozovi i poruci kolace", false);
		Task t3 = new Task("Call Vanilica Company", "vlajs16", new GregorianCalendar(2015, GregorianCalendar.MAY, 20), cow1,
				"Pozovi i poruci kolace", false);
		Task t4 = new Task("Call Vanilica Company Tea", "acimovljeva", new GregorianCalendar(2018, GregorianCalendar.FEBRUARY, 20), cow1,
				"Pozovi i poruci kolace", false);
		
		
		Tasks tasks = new Tasks();
		tasks.AddTaskToDo(t1);
		tasks.AddTaskToDo(t2);
		tasks.AddTaskToDo(t3);
		tasks.AddTaskToDo(t4);
		tasks.AddTaskToDo(t1);
		
		tasks.saveTasks(Paths.tasksPath, Paths.doneTasksPath);
//		tasks.LoadTasks(Paths.tasksPath, Paths.doneTasksPath);
//		for(int i = 0; i<tasks.getTasks().size(); i++)
//			System.out.println(tasks.getTasks().get(i));
//		System.out.println();
//		ArrayList<Task> tillToday = tasks.showTillToday(u3);
//		for(int i = 0; i<tillToday.size(); i++)
//			System.out.println(tillToday.get(i));
		
//		System.out.println(u3.getUsername());
//		System.out.println(".");
//		tasks.AddTaskDone(t1);
//		for(int i = 0; i<tasks.getDoneTasks().size(); i++)
//			System.out.println(tasks.getDoneTasks().get(i));
		
	}
}
