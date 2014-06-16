package fcg;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Stops moving cards when mouse leaves frame
 * 
 * @author Alex
 *
 */
public class FrameListener implements MouseListener {

	static boolean drag = true;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		drag = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		drag = false;
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
