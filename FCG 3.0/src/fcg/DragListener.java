package fcg;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * Allows card to be dragged
 * 
 * @author Alex
 * 
 */
public class DragListener implements MouseMotionListener {

	// Keeps last point in memory
	static Point lastPoint = new Point();

	@Override
	public void mouseDragged(MouseEvent arg0) {
		Card card = (Card) arg0.getSource();
		if (FrameListener.drag) {
			if (card.isDraggable()) {
				if (lastPoint.x != 0) {
					int x = 0;
					int y = 0;
					int xLoc = card.getLocation().x;
					int yLoc = card.getLocation().y;
					int xDiff = lastPoint.x - arg0.getLocationOnScreen().x;
					int yDiff = lastPoint.y - arg0.getLocationOnScreen().y;

					// Collision detection for x axis
					if ((xLoc - xDiff) + card.getWidth() > Game.frame
							.getWidth()) {
						x = Game.frame.getWidth() - card.getWidth();
					} else if (xLoc - xDiff < 0) {
						x = 0;
					} else {
						x = xLoc - xDiff;
					}

					// Collision detection for y axis
					if ((yLoc - yDiff) + card.getHeight() > Game.frame
							.getHeight()) {
						y = Game.frame.getHeight() - card.getHeight();
					} else if (yLoc - yDiff < 0) {
						y = 0;
					} else {
						y = yLoc - yDiff;
					}

					card.setLocation(x, y);

					// Puts the card on top of all other cards
					Game.panel.setComponentZOrder(card, nonCards(Game.panel));
				}
				lastPoint.x = arg0.getLocationOnScreen().x;
				lastPoint.y = arg0.getLocationOnScreen().y;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	private int nonCards(JPanel panel) {
		int i = 0;
		Component[] comp = panel.getComponents();
		for (int j = 0; j < comp.length; j++) {
			// Checks to see if card is extended from Card class
			if (comp[j].getClass().getSuperclass() != (Card.class)) {
				i++;
			}
		}
		return i;
	}

}
