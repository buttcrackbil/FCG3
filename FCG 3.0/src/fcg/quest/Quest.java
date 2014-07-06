package fcg.quest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fcg.Client;
import fcg.Game;
import fcg.city.City;

/**
 * Self-explanatory
 * 
 * @author Alex
 * 
 */
public class Quest {

	private City city;

	protected boolean started;

	protected int tasks = 1;

	protected int maxTasks;

	protected Task task;

	protected JLabel messageLabel = new JLabel();

	/**
	 * @param par1
	 *            City that the quest starts in
	 * @param name
	 *            Name of the quest
	 * @param tasks
	 *            Parts of the quest
	 */
	public Quest(City par1, String name, Task... tasks) {
		city = par1;
		for (int i = 0; i < tasks.length; i++) {
			tasks[i].setQuest(this);
			tasks[i].setID(i + 1);
			if (i == tasks.length - 1) {
				task = tasks[i];
			}
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
		JButton yes = new JButton("Accept");
		JButton no = new JButton("Cancel");
		final JLabel label = new JLabel("Do you want to start this quest?");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.RED);
		label.setBounds(Game.frame.getWidth() / 3, Game.frame.getHeight() / 3,
				Game.frame.getWidth() / 3, Game.frame.getHeight() / 3);
		yes.setBounds(label.getWidth() / 2,
				label.getHeight() - (label.getHeight() / 10),
				label.getWidth() / 2, label.getHeight() / 10);
		no.setBounds(0, label.getHeight() - (label.getHeight() / 10),
				label.getWidth() / 2, label.getHeight() / 10);
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				city.remove(label);
				city.repaint();
				started = true;
			}

		});
		no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				city.remove(label);
				city.repaint();
			}

		});
		label.add(yes);
		label.add(no);
		city.add(label);
		city.repaint();
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

	private JLabel showMessage() {
		messageLabel.setText("You have finished the quest");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setVerticalAlignment(SwingConstants.CENTER);
		messageLabel.setOpaque(true);
		messageLabel.setBackground(Color.RED);
		messageLabel.setSize(Game.frame.getWidth() / 3,
				Game.frame.getHeight() / 3);
		messageLabel.setLocation(
				(Game.frame.getWidth() - messageLabel.getWidth()) / 2,
				(Game.frame.getHeight() - messageLabel.getHeight()) / 2);
		messageLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Client.getCity().remove(messageLabel);
				Client.getCity().repaint();
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
		return messageLabel;
	}

	protected void checkComplete() {
		if (tasks == maxTasks + 1) {
			task.city.add(showMessage());
		}
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
