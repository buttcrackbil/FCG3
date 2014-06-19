package fcg.quest;

import fcg.card.Card;
import fcg.city.City;

/**
 * A part of a test
 * 
 * @author Alex
 * 
 */
public class Task {

	private Quest quest;

	private boolean completed;

	private int id;

	@SuppressWarnings("javadoc")
	public Task(City city) {
		city.addTask(this);
	}

	protected Task(Card card) {

	}

	protected void setQuest(Quest quest) {
		this.quest = quest;
	}

	/**
	 * Gets quest this task is connected to
	 * 
	 * @return The connected quest
	 */
	public Quest getQuest() {
		return quest;
	}

	/**
	 * Checks to see if the connected quest has been started
	 * 
	 * @return true if started
	 */
	public boolean questStarted() {
		return quest.started;
	}

	/**
	 * Sets the task to completed
	 * 
	 * @param b
	 *            True if task is complete
	 */
	public void setCompleted(boolean b) {
		completed = b;
		quest.tasks++;
	}

	/**
	 * @return True if completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	protected void setID(int ID) {
		id = ID;
	}

	/**
	 * @return The ID of the task according to it's quest
	 */
	public int getTaskID() {
		return id;
	}
}
