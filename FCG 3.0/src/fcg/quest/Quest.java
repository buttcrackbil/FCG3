package fcg.quest;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fcg.city.City;
import fcg.panels.LabelButton;

/**
 * Self-explanatory
 * 
 * @author Alex
 * 
 */
public class Quest {

	private City city;

	private LabelButton button;

	protected boolean started;

	protected int tasks = 1;

	protected int maxTasks;

	/**
	 * @param par1
	 *            City that the quest starts in
	 * @param name
	 *            Name of the quest
	 * @param tasks
	 *            Parts of the quest
	 */
	public Quest(City par1, String name, Task... tasks) {
		button = new LabelButton(name, new QuestListener());
		par1.addChoice(button);
		city = par1;
		for (int i = 0; i < tasks.length; i++) {
			tasks[i].setQuest(this);
			tasks[i].setID(i + 1);
		}
		this.maxTasks = tasks.length;
	}

	/**
	 * Specifically for the listener
	 */
	public Quest() {

	}

	/**
	 * Runs the quest
	 */
	public void start() {
		started = true;
		getCity().removeChoice(button);
	}

	/**
	 * @return The task the quest is on
	 */
	public int taskID() {
		return tasks;
	}

	/**
	 * @return City that the quest starts in
	 */
	public City getCity() {
		return city;
	}

	class QuestListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			start();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
