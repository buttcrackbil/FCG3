package fcg.city;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fcg.Client;
import fcg.Game;
import fcg.card.Card;
import fcg.panels.LabelButton;
import fcg.travel.CityMarker;

/**
 * A city
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public abstract class City extends JPanel {

	private static City addedCity;

	private String cityName;

	private LabelButton ret;

	private JLabel nameLabel;

	private CityMarker city;

	private Menu menu;

	Shop shop;

	@SuppressWarnings("javadoc")
	public static ArrayList<City> cities = new ArrayList<City>();

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
		city = new CityMarker(x, y, this);
		ret = new LabelButton("Quit SP", new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Client.getCity().remove(Client.getCity().shop);
				Menu.shopShowing = false;
				Client.getCity().repaint();
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
		menu = cityMenu();
		shop = cityShop();
		add(menu);
		cities.add(this);
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
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i) == this) {
				ret = i;
			}
		}
		return ret;
	}

	/**
	 * Gets the city marker associated with this city
	 * 
	 * @return City marker
	 */
	public CityMarker getCityMarker() {
		return city;
	}

	protected abstract Menu cityMenu();

	protected abstract Shop cityShop();

	@SuppressWarnings("javadoc")
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface FCGCityInitialization {

	}
}
