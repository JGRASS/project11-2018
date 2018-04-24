package classes.task;

import java.io.Serializable;
import java.util.GregorianCalendar;

import classes.coworker.CoWorker;

/**
 * Klasa koja predstavlja zadatak
 * @author vlajs16
 *
 */
public class Task implements Serializable, Comparable<Task> {
	/**
	 * ID klase Task
	 */
	private static final long serialVersionUID = -3523333824926124267L;
	/**
	 * Naslov zadatka
	 */
	private String taskTitle;
	/**
	 * Username zaposenog
	 */
	private String username;
	/**
	 * Datum
	 */
	private GregorianCalendar date;
	/**
	 * Kontakt za saradnju prilikom izvrsenja zadatka
	 */
	private CoWorker coWorker;
	/**
	 * Opis zadatka
	 */
	private String description;
	/**
	 * Da li je zadatak odradjen ili ne
	 */
	private boolean done;
	
	/**
	 * Komentar zadatka
	 */
	private String comment;
	
	/**
	 * Vraca String sa naslovom zadatka
	 * @return taskTitle naslov zadatka
	 */	
	@Override
	public String toString() {
		return taskTitle;
	}

	/**
	 * Vraca naslov zadatka
	 * @return taskTitle naslov zadatka
	 */
	public String getTaskTitle() {
		return taskTitle;
	}
	
	/**
	 * Vraca komentar zadatka
	 * @return comment komentar zadatka
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Postavlja novu vrednost za komentar
	 * @param comment nova vrednost komentara
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * Vraca username zaposlenog
	 * @return username zaposlenog
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Postavlja novu vrednost za username
	 * @param username nova vrednost username-a
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Postavlja novu vrednost za naslov zadatka
	 * @param taskTitle naslov zadatka
	 * @throws java.lang.RuntimeException ako je unet naslov zadatka:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>prazan String</li>
	 * <li>duzine manje od 8 karaktera</li>
	 * </ul>
	 */
	public void setTaskTitle(String taskTitle) {
		if (taskTitle.equals(null))
			throw new RuntimeException("Task title is null");
		if (taskTitle.isEmpty())
			throw new RuntimeException("Task title is empty string");
		if (taskTitle.length() < 8)
			throw new RuntimeException("Task title is too short");
		this.taskTitle = taskTitle;
	}

	/**
	 * Vraca datum
	 * @return date datum
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * Postavlja novu vrednost za datum
	 * @param date datum
	 * @throws java.lang.RuntimeException ako je unet datum:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>neki datum u proslosti</li>
	 * </ul>
	 */
	public void setDate(GregorianCalendar date) {
		if (date.equals(null))
			throw new RuntimeException("Date is null");
		if (date.before(new GregorianCalendar()))
			throw new RuntimeException("You cannot schedule a task in the past");
		this.date = date;
	}

	/**
	 * Vraca zaposlenog
	 * @return coWorker zaposleni
	 */
	public CoWorker getCoWorker() {
		return coWorker;
	}

	/**
	 * Postavlja novu vrednost za zaposlenog
	 * @param coWorker zaposleni
	 * @throws java.lang.RuntimeException ako je vrednost saradnika null
	 */
	public void setCoWorker(CoWorker coWorker) {
		if (coWorker.equals(null))
			throw new RuntimeException("CoWorker is null");
		this.coWorker = coWorker;
	}

	/**
	 * Vraca opis zadatka
	 * @return description opis zadatka
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Postavlja novu vrednost za opis zadatka
	 * @param description opis zadatka
	 * @throws java.lang.RuntimeException ako je uneti opis zadatka:
	 * <ul style="list-style-type:circle">
	 * <li>null vrednost</li>
	 * <li>prazan String</li>
	 * <li>duzina opisa manja od 10</li>
	 * </ul>
	 */
	public void setDescription(String description) {
		if (description.equals(null))
			throw new RuntimeException("Description is null");
		if (description.isEmpty())
			throw new RuntimeException("Description is empty string");
		if (description.length() < 10)
			throw new RuntimeException("Description is too short");
		this.description = description;
	}

	/**
	 * Da li je odradjen zadatak
	 * @return done true ako jeste, false ako nije
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * Postavlja novu vrednost za done
	 * @param done nova vrednost done
	 */
	public void setDone(boolean done) {
		this.done = done;
	}
	/**
	 * Proverava da li su dva zadatka ista
	 * Poredi po atributu username
	 * @return true ako su zadaci isti, a false ako nisu
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (username != other.username)
			return false;
		return true;
	}	
	/**
	 * Metoda iz interfejsa Comparable
	 */
	@Override
	public int compareTo(Task o) {
		return this.getDate().compareTo(o.getDate());
	}

}
