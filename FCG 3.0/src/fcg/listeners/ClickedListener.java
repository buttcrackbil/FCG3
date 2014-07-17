package fcg.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fcg.card.Card;
import fcg.card.LivingCard;
import fcg.card.Weapon;

/**
 * Resets DragListener variable
 * 
 * @author Alex
 * 
 */
public class ClickedListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Class<?> cardClass = arg0.getSource().getClass();
		if (cardClass == LivingCard.class || cardClass == Weapon.class) {
			Card card = (Card) arg0.getSource();
			card.setSelected(!card.isSelected());
			card.repaint();
		}
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
