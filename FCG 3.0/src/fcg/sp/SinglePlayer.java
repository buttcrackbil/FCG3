package fcg.sp;

import fcg.Client;
import fcg.Game;

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
		Game.frame.remove(Game.panel);
		Game.frame.repaint();
		Client.getCity().show(Game.frame);
	}
}
