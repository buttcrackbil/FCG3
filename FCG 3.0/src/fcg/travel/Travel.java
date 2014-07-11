package fcg.travel;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import fcg.Client;
import fcg.Game;
import fcg.city.City;
import fcg.listeners.TravelListener;

/**
 * Large panel that has all city markers on it
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class Travel extends JPanel {

	private static int days;

	@SuppressWarnings("javadoc")
	public Travel() {
		setSize(Game.frame.getWidth(), Game.frame.getHeight());
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		addMouseMotionListener(new TravelListener());
		addMouseWheelListener(new TravelListener());
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				TravelListener.lastPoint = new Point();
			}
		});
		for (int i = 0; i < City.cities.size(); i++) {
			add(City.cities.get(i).getCityMarker());
		}
		int x = (Game.frame.getWidth() / 2)
				- Client.getCity().getCityMarker().getLocation().x;
		int y = (Game.frame.getHeight() / 2)
				- Client.getCity().getCityMarker().getLocation().y;
		if (x > 0) {
			x = 0;
		} else if (x < Game.frame.getWidth() - getWidth()) {
			x = Game.frame.getWidth() - getWidth();
		}
		if (y > 0) {
			y = 0;
		} else if (y < Game.frame.getHeight() - getHeight()) {
			y = Game.frame.getHeight() - getHeight();
		}
		setLocation(x, y);
		repaint();
	}

	/**
	 * Brings up the move panel
	 * 
	 * @param city
	 *            City the player is traveling to
	 */
	public static void travel(City city) {
		getDays(city);
		Game.frame.add(new Move(days, city));
		Game.frame.repaint();
	}

	private static void getDays(City city) {
		days = 0;
		Point preCity = Client.getCity().getCityMarker().getLocation();
		Point postCity = city.getCityMarker().getLocation();
		int xDiff = Math.abs(preCity.x - postCity.x);
		int yDiff = Math.abs(preCity.y - postCity.y);
		while (xDiff >= (Game.frame.getWidth() / 16)) {
			days++;
			xDiff -= (Game.frame.getWidth() / 16);
		}
		if (xDiff > 0) {
			days++;
		}
		while (yDiff >= (Game.frame.getHeight() / 9)) {
			yDiff -= (Game.frame.getHeight() / 9);
			days++;
		}
		if (yDiff > 0) {
			days++;
		}
	}
}
