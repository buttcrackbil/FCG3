package fcg.sp;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import fcg.Game;

/**
 * Label that is selectable
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class UserLabel extends JLabel {

	/**
	 * The selected user
	 */
	public static JLabel selected = null;

	/**
	 * @param name String to be displayed on label
	 */
	public UserLabel(String name) {
		super(name);
		setOpaque(true);
		setBackground(Color.RED);
		setSize(Game.panel.getWidth() / 3, 50);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
				repaint();
				if (selected != null) {
					selected.setBorder(null);
					selected.repaint();
				}
				if (selected == (UserLabel) arg0.getSource()) {
					selected = null;
				} else {
					selected = (UserLabel) arg0.getSource();
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

		});
	}
}
