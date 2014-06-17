package fcg.city;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fcg.Game;
import fcg.panels.LabelButton;

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
	public static City[] cities = { new City("Debug City"),
			new City("Test City") };

	private String cityName;

	private LabelButton ret;

	private JLabel nameLabel;

	private static City addedCity;

	/**
	 * City constructor
	 * 
	 * @param name
	 *            City's name
	 */
	public City(String name) {
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
	}

	/**
	 * Shows City on frame
	 * 
	 * @param frame
	 *            Frame City is to be added to
	 */
	public void show(JFrame frame) {
		addedCity = this;
		frame.add(this);
		frame.repaint();
	}

	/**
	 * Goes back to main menu
	 */
	public static void close() {
		Game.frame.remove(addedCity);
		Game.main(new String[] {});
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
}
