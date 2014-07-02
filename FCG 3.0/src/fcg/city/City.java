package fcg.city;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fcg.Client;
import fcg.Game;
import fcg.card.Card;
import fcg.panels.LabelButton;
import fcg.quest.Task;
import fcg.travel.CityMarker;

/**
 * A city
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class City extends JPanel {

	/**
	 * All cities
	 */
	public static City[] cities = { new City("Debug City", 250, 250),
			new City("Test City", 100, 100) };

	private static City addedCity;

	private String cityName;

	private LabelButton ret;

	private JLabel nameLabel;

	private CityMenu cm;

	private CityMarker city;

	private ArrayList<Task> tasks = new ArrayList<Task>();

	/**
	 * City constructor
	 * 
	 * @param name
	 *            City's name
	 * @param x
	 *            X location of city marker
	 * @param y
	 *            Y location of city marker
	 */
	public City(String name, int x, int y) {
		cm = new CityMenu();
		city = new CityMarker(x, y, this);
		ret = new LabelButton("Quit SP", new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				close();
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
		setSize(Game.frame.getSize());
		setLocation(0, 0);
		setBackground(Color.BLUE);
		ret.setLocation(0, getHeight() - (getWidth() / 20));
		nameLabel = new JLabel();
		nameLabel.setSize(getWidth() / 3, getHeight() / 15);
		nameLabel.setLocation((getWidth() - nameLabel.getWidth()) / 2, 0);
		int i;
		FontMetrics fm;
		for (i = 50; i > 1;) {
			nameLabel.setFont(new Font("TimesRoman", Font.PLAIN, i));
			fm = this.getFontMetrics(nameLabel.getFont());
			if (fm.getHeight() > nameLabel.getHeight()) {
				i--;
			} else {
				break;
			}
		}
		nameLabel.setText(name);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setVerticalAlignment(SwingConstants.TOP);
		cityName = name;
		add(ret);
		add(nameLabel);
		add(cm);
	}

	/**
	 * Shows City on frame
	 * 
	 * @param frame
	 *            Frame City is to be added to
	 */
	public void show(JFrame frame) {
		Client.setCity(this);
		addedCity = this;
		frame.add(this);
		frame.repaint();
		checkTasks();
	}

	/**
	 * Goes back to main menu
	 */
	public static void close() {
		Game.frame.remove(addedCity);
		Card.list.clear();
		Game.main(new String[] {});
		Game.frame.repaint();
	}

	public String getName() {
		return cityName;
	}

	/**
	 * Returns city ID or -1 if no ID was assigned
	 * 
	 * @return City ID
	 */
	public int getID() {
		int ret = -1;
		for (int i = 0; i < cities.length; i++) {
			if (cities[i] == this) {
				ret = i;
			}
		}
		return ret;
	}

	/**
	 * Adds a choice in the City home screen
	 * 
	 * @param button
	 *            Choices to add to menu
	 * @return Just to allow more compressed coding
	 */
	public City addChoice(LabelButton button) {
		cm.addChoice(button);
		return this;
	}

	/**
	 * Removes choice from city menu
	 * 
	 * @param button
	 *            Choice to be removed
	 */
	public void removeChoice(LabelButton button) {
		cm.removeChoice(button);
	}

	/**
	 * Gets the city marker associated with this city
	 * 
	 * @return City marker
	 */
	public CityMarker getCityMarker() {
		return city;
	}

	/**
	 * Adds a task to the city (must visit city to complete task
	 * 
	 * @param task
	 *            Task from a quest
	 */
	public void addTask(Task task) {
		tasks.add(task);
	}

	/**
	 * Checks to see if any tasks are completed upon going to the city
	 */
	public void checkTasks() {
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			if (task.questStarted()) {
				if (task.getQuest().taskID() == task.getTaskID()) {
					task.setCompleted(true);
				}
			}
		}
	}
}
