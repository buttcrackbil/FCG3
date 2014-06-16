package fcg.sp;

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
		Game.panel.removeAll();
		Game.panel.add(Game.quit);
		Game.panel.repaint();
	}
}
