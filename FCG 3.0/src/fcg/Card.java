package fcg;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JLabel;

/**
 * A displayable card
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class Card extends JLabel {

	private String name;

	private boolean draggable = true;

	/**
	 * Constructor
	 * 
	 * @param string
	 *            Name of card
	 */
	public Card(String string) {
		setSize(150, 225);
		name = string;
	}

	public String getName() {
		return name;
	}

	public void paint(Graphics g) {
		addMouseMotionListener(new DragListener());
		addMouseListener(new ClickedListener());
		setSize(Game.cardWidth, Game.cardHeight);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawString(name, 0, 10);
	}

	/**
	 * Sets the card's drag ability
	 * 
	 * @param b
	 *            True to allow card to be dragged around screen
	 */
	public void setDraggable(boolean b) {
		draggable = b;
	}

	/**
	 * Checks to see if the card is allowed to be dragged around the screen
	 * 
	 * @return True if can be dragged around screen
	 */
	public boolean isDraggable() {
		return draggable;
	}

	/**
	 * Draws description and makes sure it all fits on screen
	 * 
	 * @param lv
	 *            Card this is being drawn to
	 * @param g
	 *            Graphics object
	 * @param par1
	 *            String to be drawn
	 */
	public static void drawLine(LivingCard lv, Graphics g, String par1) {
		FontMetrics fm = g.getFontMetrics();
		if (fm.stringWidth(par1) > lv.getWidth()) {
			System.out.println("Description line #" + lv.stringAttempt
					+ " from " + lv.getName() + " is too long");
			lv.stringAttempt++;
		} else {
			g.drawString(par1, 4, lv.descriptionHeight + (10 * lv.lines));
			lv.lines++;
			lv.stringAttempt++;
		}
	}
}
