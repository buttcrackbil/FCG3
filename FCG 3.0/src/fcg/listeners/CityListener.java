package fcg.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

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
		((City) City.cities[((City) city.getCity()).getID()]).show(Game.frame);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		CityMarker city = (CityMarker) arg0.getSource();
		Travel travel = (Travel) city.getParent();
		name = new JLabel(city.getCity().getName());
		name.setSize(Game.buttonSize, 20);
		name.setLocation(city.getLocation().x - 10, city.getLocation().y - 20);
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
