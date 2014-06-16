package fcg;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Resets DragListener variable
 * 
 * @author Alex
 * 
 */
public class ClickedListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		FrameListener.drag = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		FrameListener.drag = false;

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		DragListener.lastPoint = new Point();
	}

}
