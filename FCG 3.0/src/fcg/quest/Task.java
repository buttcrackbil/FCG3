package fcg.quest;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fcg.Game;
import fcg.card.Card;
import fcg.city.City;

/**
 * A part of a quest
 * 
 * @author Alex
 * 
 */
public class Task {

	private Quest quest;

	private boolean completed;

	private int id;

	protected City city;

	private String name;

	private JLabel messageLabel = new JLabel();

	/**
	 * @param name
	 *            Name of the task
	 * @param city
	 *            City this task is in
	 */
	public Task(String name, City city) {
		this.city = city;
		this.name = name;
	}

	// [WIP]
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
		showMessage();
		city.repaint();
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

	private void showMessage() {
		messageLabel.setText("<html><u>" + name + "</u> was completed."
				+ " (Click to dismiss)" + "</html>");
		messageLabel.setOpaque(true);
		messageLabel.setBackground(Color.RED);
		messageLabel.setSize(Game.frame.getWidth() / 3,
				Game.frame.getHeight() / 3);
		messageLabel.setLocation(
				(Game.frame.getWidth() - messageLabel.getWidth()) / 2,
				(Game.frame.getHeight() - messageLabel.getHeight()) / 2);
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setVerticalAlignment(SwingConstants.CENTER);
		city.add(messageLabel);
		messageLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				city.remove(messageLabel);
				city.repaint();
				quest.checkComplete();
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

		});
	}
}
