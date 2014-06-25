package fcg.travel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import fcg.Game;
import fcg.city.City;

/**
 * Bar that is on top of the moving panel
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class TravelBar extends JPanel {

	private int days;

	private int spentDays = 0;

	/**
	 * @param days
	 *            Days that need to be gone through to get to the next city
	 * @param panel
	 *            Panel that bar is added to
	 */
	public TravelBar(int days, JPanel panel) {
		setSize(panel.getWidth(), panel.getWidth() / 18);
		setLocation(0, 0);
		this.days = days;
	}

	public void paint(Graphics g) {
		int color = (getWidth() - getHeight()) / days;
		drawCircle(g, Color.white, 0, 0, getHeight() / 2);
		drawRect(g, Color.white, getHeight() / 2, 0, days * color, getHeight());
		drawCircle(g, Color.LIGHT_GRAY, 0, 0, getHeight() / 2);
		drawRect(g, Color.LIGHT_GRAY, getHeight() / 2, 0, spentDays * color,
				getHeight());
	}

	protected boolean spendDay() {
		boolean b = false;
		if (spentDays + 1 > days) {
			City city = ((Move) getParent()).city;
			Game.frame.remove(getParent());
			city.show(Game.frame);
		} else {
			spentDays++;
			b = true;
			repaint();
		}
		return b;
	}

	private void drawCircle(Graphics g, Color c, int x, int y, int radius) {
		g.setColor(c);
		g.fillOval(x, y, radius * 2, radius * 2);
	}

	private void drawRect(Graphics g, Color c, int x, int y, int i, int j) {
		g.setColor(c);
		g.fillRect(x, y, i, j);
		drawCircle(g, c, x + (i - (getHeight() / 2)), y, getHeight() / 2);
	}
}
