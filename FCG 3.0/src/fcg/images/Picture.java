package fcg.images;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import fcg.Game;

/**
 * Loads picture
 * 
 * @author Alex
 * 
 */
public class Picture {

	/**
	 * @param g
	 *            Graphics object to paint to
	 * @param borderWidth
	 *            Width of border
	 * @param picString
	 *            Picture name (just filename.extension, not location)
	 */
	public static void addPicture(Graphics g, int borderWidth, String picString) {
		if (picString != null) {
			try {
				BufferedImage myPicture = ImageIO.read(Picture.class
						.getResource(picString));
				g.drawImage(myPicture, borderWidth, borderWidth, Game.cardWidth
						- (borderWidth * 2), Game.cardHeight
						- (borderWidth * 2), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param g
	 *            Graphics object to paint to
	 * @param picString
	 *            Picture name (just filename.extension, not location)
	 * @param comp
	 *            Component to be painted to
	 */
	public static void addBackground(Graphics g, String picString,
			Component comp) {
		if (picString != null) {
			try {
				BufferedImage myPicture = ImageIO.read(comp.getClass()
						.getResource(picString));
				g.drawImage(myPicture, 0, 0, comp.getWidth(), comp.getHeight(),
						null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
