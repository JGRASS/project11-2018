package system_operations;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import classes.task.Task;

public class SOLoadTasks {
	
	/**
	 * Ucitavanje liste zadataka iz serijalizovanog fajla
	 * @param file fajl sa zadacima
	 * @return lista zadataka
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Task> execute(String file) {
		try(ObjectInputStream in = 
				new ObjectInputStream(
						new FileInputStream(file))){
			return (ArrayList<Task>) in.readObject();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
}
