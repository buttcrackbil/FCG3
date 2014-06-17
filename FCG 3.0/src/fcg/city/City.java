package fcg.city;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	public static City[] cities = { new City("Debug City"), new City("Test City") };

	private String cityName;
	
	private LabelButton ret;
	
	private static City addedCity;
	
	/**
	 * City constructor
	 * 
	 * @param name City's name
	 */
	public City(String name) {
		ret = new LabelButton("Quit", new MouseListener() {

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
		cityName = name;
		add(ret);
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
	
	public String getName(){
		return cityName;
	}
	
	/**
	 * Returns city ID or -1 if no ID was assigned
	 * 
	 * @return City ID
	 */
	public int getID(){
		int ret = -1;
		for(int i = 0; i < cities.length; i++){
			if(cities[i] == this){
				ret = i;
			}
		}
		return ret;
	}
}