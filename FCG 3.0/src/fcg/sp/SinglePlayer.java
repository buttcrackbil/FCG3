package fcg.sp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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

	/**
	 * Select player panel
	 */
	public static void selectPlayer() {
		final JPanel panel = new JPanel();
		MouseListener ml = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel label = (JLabel) arg0.getSource();
				switch (label.getText()) {
				case "Cancel":
					Game.panel.remove(panel);
					Game.panel.repaint();
					break;
				case "Accept":
					break;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		};
		panel.setLayout(null);
		panel.setSize(Game.panel.getWidth() / 3, Game.panel.getHeight() / 3);
		panel.setLocation((Game.panel.getWidth() - panel.getWidth()) / 2,
				(Game.panel.getHeight() - panel.getHeight()) / 2);
		JLabel accept = new JLabel("Accept");
		accept.setHorizontalAlignment(SwingConstants.CENTER);
		accept.setSize(panel.getWidth() / 2, panel.getHeight() / 10);
		accept.setLocation(panel.getWidth() / 2,
				panel.getHeight() - accept.getHeight());
		JLabel decline = new JLabel("Cancel");
		decline.setHorizontalAlignment(SwingConstants.CENTER);
		decline.setSize(panel.getWidth() / 2, panel.getHeight() / 10);
		decline.setLocation(0, panel.getHeight() - decline.getHeight());
		accept.addMouseListener(ml);
		decline.addMouseListener(ml);
		panel.add(accept);
		panel.add(decline);
		Game.panel.add(panel);
		Game.panel.repaint();
	}
}
