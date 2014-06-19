package fcg.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fcg.Game;
import fcg.travel.Travel;

/**
 * Listens to the travel panel
 * 
 * @author Alex
 * 
 */
public class TravelListener implements MouseMotionListener, MouseWheelListener {

	/**
	 * Keeps track of last point while dragging
	 */
	public static Point lastPoint = new Point();

	@Override
	public void mouseDragged(MouseEvent arg0) {
		int x = 0;
		int y = 0;
		int xDiff = lastPoint.x - arg0.getLocationOnScreen().x;
		int yDiff = lastPoint.y - arg0.getLocationOnScreen().y;
		if (lastPoint.x != 0) {
			Travel travel = (Travel) arg0.getSource();
			x = travel.getLocation().x - xDiff;
			y = travel.getLocation().y - yDiff;
			if (x > 0) {
				x = 0;
			} else if (x < Game.frame.getWidth() - travel.getWidth()) {
				x = Game.frame.getWidth() - travel.getWidth();
			}
			if (y > 0) {
				y = 0;
			} else if (y < Game.frame.getHeight() - travel.getHeight()) {
				y = Game.frame.getHeight() - travel.getHeight();
			}
			travel.setLocation(x, y);
		}
		lastPoint.x = arg0.getLocationOnScreen().x;
		lastPoint.y = arg0.getLocationOnScreen().y;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		int notches = arg0.getWheelRotation();
		@SuppressWarnings("unused")
		Travel travel = (Travel) arg0.getSource();
		if (notches > 0) {
			// System.out.println("Zoomed out");
		} else {
			// System.out.println("Zoomed in");
		}
	}

}
