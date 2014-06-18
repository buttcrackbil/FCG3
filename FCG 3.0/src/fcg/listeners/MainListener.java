package fcg.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import fcg.Client;
import fcg.Game;
import fcg.panels.LabelButton;
import fcg.sp.SinglePlayer;

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
			if (button.isEnabled()) {
				if (button == Game.quit) {
					System.exit(0);
				}
				if (button == Game.singlePlayer) {
					SinglePlayer.start();
				}
				if (button == Game.multiPlayer) {
				}
				if (button == Game.switchUser) {
					Client.selectPlayer();
				}
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
