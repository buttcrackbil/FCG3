package fcg.city;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		ret.setLocation(0, getHeight() - (getWidth() / 20));
		cityName = name;
		add(ret);
	}

	/**
	 * Shows City on panel
	 * 
	 * @param panel
	 *            Panel City is to be added to
	 */
	public void show(JPanel panel) {
		panel.removeAll();
		panel.add(this);
		panel.repaint();
	}

	/**
	 * Goes back to main menu
	 */
	public static void close() {
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
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
		ret.repaint();
		setSize(Game.frame.getSize());
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
		FontMetrics fm = g.getFontMetrics();
		g.drawString(cityName + getID(), (getWidth() - fm.stringWidth(cityName)) / 2, 20);
	}
}
