package fcg.travel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fcg.Game;
import fcg.city.City;
import fcg.listeners.CityListener;
import fcg.panels.LabelButton;

/**
 * A panel that allows you to travel
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class CityMarker extends JLabel {

	private City city;

	/**
	 * A clickable circle that leads to a city
	 * 
	 * @param x
	 *            X pos of circle (center of circle)
	 * @param y
	 *            Y pos of circle (center of circle)
	 * @param home
	 *            City that this leads to
	 */
	public CityMarker(int x, int y, City home) {
		city = home;
		setFont(LabelButton.font);
		setSize(Game.buttonSize / 4, Game.buttonSize / 4);
		setLocation(x - getWidth(), y - getHeight());
		setVerticalAlignment(SwingConstants.BOTTOM);
		setHorizontalAlignment(SwingConstants.CENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new CityListener());
	}

	/**
	 * Gets the connected city
	 * 
	 * @return The city this label is connected to
	 */
	public City getCity() {
		return city;
	}

	public void paint(Graphics g) {
		drawCircle(g, Color.BLACK, 0, 0, getWidth() / 2);
	}

	private static void drawCircle(Graphics g, Color c, int x, int y, int radius) {
		g.setColor(c);
		g.fillOval(x, y, radius * 2, radius * 2);
	}
}
