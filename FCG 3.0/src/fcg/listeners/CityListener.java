package fcg.listeners;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fcg.Client;
import fcg.Game;
import fcg.city.City;
import fcg.travel.CityMarker;
import fcg.travel.Travel;

/**
 * Listens to the city markers
 * 
 * @author Alex
 * 
 */
public class CityListener implements MouseListener {

	JLabel name;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		CityMarker city = (CityMarker) arg0.getSource();
		Travel travel = (Travel) city.getParent();
		Game.frame.remove(travel);
		if (city.getCity() == Client.getCity()) {
			Client.getCity().show(Game.frame);
		} else if (city.getCity() != Client.getCity()) {
			Travel.travel(City.cities.get(city.getCity().getID()));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		CityMarker city = (CityMarker) arg0.getSource();
		Travel travel = (Travel) city.getParent();
		name = new JLabel(city.getCity().getName());
		Font font = name.getFont();
		FontMetrics fm = name.getFontMetrics(font);
		int fw = fm.stringWidth(city.getCity().getName());
		name.setSize(fw, 20);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		int xDiff = Math.abs((name.getWidth() - city.getWidth()) / 2);
		name.setLocation(city.getLocation().x - xDiff,
				city.getLocation().y - 20);
		travel.add(name);
		travel.repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		CityMarker city = (CityMarker) arg0.getSource();
		Travel travel = (Travel) city.getParent();
		travel.remove(name);
		travel.repaint();
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
