package fcg.sp;

import fcg.Client;
import fcg.Game;
import fcg.city.City;

/**
 * Place where all singleplayer things are started
 * 
 * @author Alex
 * 
 */
public class SinglePlayer {

	/**
	 * Starts singleplayer
	 */
	public static void start() {
		Game.panel.removeAll();
		((City)City.cities[Client.getCity()]).show(Game.panel);
		Game.panel.repaint();
	}
}
