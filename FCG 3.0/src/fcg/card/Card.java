package fcg.card;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JLabel;

import fcg.Game;
import fcg.listeners.ClickedListener;
import fcg.listeners.DragListener;

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

	protected String[] description;

	protected int descriptionHeight;

	protected int lines;

	protected int stringAttempt = 0;

	/**
	 * Constructor
	 * 
	 * @param string
	 *            Name of card
	 */
	public Card(String string) {
		setSize(Game.cardWidth, Game.cardHeight);
		name = string;
	}

	public String getName() {
		return name;
	}

	public void paint(Graphics g) {
		int offset = 4;
		addMouseMotionListener(new DragListener());
		addMouseListener(new ClickedListener());
		setSize(Game.cardWidth, Game.cardHeight);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GREEN);
		g.fillRect(2, 2, getWidth() - offset, getHeight() - offset);
		g.setColor(Color.BLACK);
		g.drawString(name, offset, 10 + offset);
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
	public static void drawLine(Card lv, Graphics g, String par1) {
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
