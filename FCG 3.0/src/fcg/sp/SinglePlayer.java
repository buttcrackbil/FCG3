package fcg.sp;

import fcg.Client;
import fcg.Game;

/**
 * Place where all single-player things are started
 * 
 * @author Alex
 * 
 */
public class SinglePlayer {

	/**
	 * Starts single-player
	 */
	public static void start() {
		Game.frame.remove(Game.panel);
		Game.frame.repaint();
		Client.getCity().show(Game.frame);
	}
}
