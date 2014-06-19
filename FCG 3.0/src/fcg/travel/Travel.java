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

	/**
	 * Constructor
	 */
	public Travel() {
		setSize(Game.frame.getWidth() * 8, Game.frame.getHeight() * 8);
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
		for (int i = 0; i < City.cities.length; i++) {
			add(City.cities[i].getCityMarker());
		}
		int x = (Game.frame.getWidth() / 2)
				- City.cities[Client.getCity()].getCityMarker().getLocation().x;
		int y = (Game.frame.getHeight() / 2)
				- City.cities[Client.getCity()].getCityMarker().getLocation().y;
		if (x > 0) {
			x = 0;
		} else if (x < Game.frame.getWidth() - getWidth()) {
			x = Game.frame.getWidth() - getWidth();
		}
		if (y > 0) {
			y = 0;
		} else if (y < Game.frame.getHeight() - getHeight()) {
			y = Game.frame.getWidth() - getHeight();
		}
		setLocation(x, y);
		repaint();
	}
}
