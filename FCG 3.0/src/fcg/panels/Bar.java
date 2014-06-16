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

	private static Color[] colors = new Color[2];

	private static int maxPoints;

	private static int coloredPoints;

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
	 */
	public static void drawBar(Graphics g, int x, int y, Color color1,
			Color color2, int max, int colored) {
		int i = 10;
		while (max * i + 5 > Game.cardWidth) {
			i--;
		}
		colors[0] = color1;
		colors[1] = color2;
		maxPoints = max * i;
		coloredPoints = colored * i;
		g.setColor(colors[1]);
		drawCircle(g, colors[1], x + 2, y, 5);
		drawRect(g, colors[1], (5) + 2, y, maxPoints, 10);
		drawCircle(g, colors[0], x + 2, y, 5);
		drawRect(g, colors[0], (5) + 2, y, coloredPoints, 10);
		String string = coloredPoints / i + "/" + maxPoints / i;
		FontMetrics fm = g.getFontMetrics();
		g.setColor(Color.WHITE);
		g.drawString(string, (maxPoints - fm.stringWidth(string)) / 2, y + 10);
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
