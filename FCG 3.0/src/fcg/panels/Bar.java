package fcg.panels;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import fcg.Game;

/**
 * Creates bar that keeps track of a variable
 * 
 * @author Alex
 * 
 */
public class Bar {

	/**
	 * Creates a bar that can track a value
	 * 
	 * @param g
	 *            Graphics object to be drawn to
	 * @param x
	 *            X location
	 * @param y
	 *            Y location
	 * @param color1
	 *            Color that will be displayed with filled bar
	 * @param color2
	 *            Color that will be displayed underneath
	 * @param max
	 *            Max int of the variable
	 * @param colored
	 *            Int of filled points
	 * @param borderWidth
	 *            Width of the border
	 */
	public static void drawBar(Graphics g, int x, int y, Color color1,
			Color color2, int max, int colored, int borderWidth) {
		Color[] colors = new Color[2];
		int width = Game.cardWidth - (borderWidth * 2) - 10;
		colors[0] = color1;
		colors[1] = color2;
		int pointMultiplier = width / max;
		g.setColor(colors[1]);
		drawCircle(g, colors[1], x + borderWidth, y, 5);
		drawRect(g, colors[1], 5 + borderWidth, y, max * pointMultiplier, 10);
		drawCircle(g, colors[0], x + borderWidth, y, 5);
		drawRect(g, colors[0], 5 + borderWidth, y, colored * pointMultiplier,
				10);
		String string = colored + "/" + max;
		FontMetrics fm = g.getFontMetrics();
		g.setColor(Color.WHITE);
		g.drawString(string, (width - fm.stringWidth(string)) / 2, y + 10);
		g.setColor(Color.BLACK);
	}

	private static void drawCircle(Graphics g, Color c, int x, int y, int radius) {
		g.setColor(c);
		g.fillOval(x, y, radius * 2, radius * 2);
	}

	private static void drawRect(Graphics g, Color c, int x, int y, int i, int j) {
		g.setColor(c);
		g.fillRect(x, y, i, j);
		drawCircle(g, c, x + (i - 5), y, 5);
	}
}
