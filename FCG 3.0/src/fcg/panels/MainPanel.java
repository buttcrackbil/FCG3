package fcg.panels;

import java.awt.Graphics;

import javax.swing.JPanel;

import fcg.images.Picture;

/**
 * The main menu panel
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	public void paint(Graphics g) {
		for (int i = 0; i < this.getComponents().length; i++) {
			this.getComponents()[i].repaint();
		}
		Picture.addBackground(g, "/fcg/images/picture.png", this);
	}
}
