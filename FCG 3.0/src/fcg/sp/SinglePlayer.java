package fcg.sp;

import fcg.Client;
import fcg.Game;
import fcg.card.Card;
import fcg.content.LoadContent;

/**
 * Place where all single-player things are started
 * 
 * @author Alex
 * 
 */
public class SinglePlayer {

	@SuppressWarnings("rawtypes")
	private static Class[] classes = { Card.class };

	/**
	 * Starts single-player
	 */
	public static void start() {
		for (int i = 0; i < classes.length; i++)
			LoadContent.runContent(classes[i]);
		Game.frame.remove(Game.panel);
		Game.frame.repaint();
		Client.getCity().show(Game.frame);
	}
}
