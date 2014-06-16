package fcg;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

/**
 * Listener for the main buttons
 * 
 * @author Alex
 * 
 */
public class MainListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			LabelButton button = (LabelButton) arg0.getSource();
			if (button == Game.quit) {
				System.out.println("Quitting game");
				System.exit(0);
			}
			if (button == Game.singlePlayer) {
				System.out.println("Starting singleplayer");
				Game.card.hurt(5);
			}
			if (button == Game.multiPlayer) {
				System.out.println("Starting multiplayer");
				Game.card.heal(5);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
