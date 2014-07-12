package fcg.card;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

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

	// End of cards

	private String name;

	protected boolean draggable = true;

	protected boolean selectable = false;

	protected boolean selected = false;

	protected String[] description;

	protected int descriptionHeight;

	protected int lines;

	protected int stringAttempt = 0;

	/**
	 * All cards
	 */
	public static ArrayList<Card> list = new ArrayList<Card>();

	/**
	 * Constructor
	 * 
	 * @param string
	 *            Name of card
	 * @param register
	 *            True to register card, false if making card copy
	 */
	public Card(String string, boolean register) {
		setSize(Game.cardWidth, Game.cardHeight);
		name = string;
		if (register) {
			System.out.println("Setting " + string + " to ID "
					+ (list.size() + 1));
			list.add(this);
		}
	}

	public String getName() {
		return name;
	}

	public void paint(Graphics g) {
		int offset = 4;
		addMouseMotionListener(new DragListener());
		addMouseListener(new ClickedListener());
		setSize(Game.cardWidth, Game.cardHeight);
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
	 * @param b
	 *            Set true if card can be selected
	 */
	public void setSelectable(boolean b) {
		selectable = b;
	}

	/**
	 * @param b
	 *            Set true if card is selected
	 */
	public void setSelected(boolean b) {
		selected = b;
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
	 * @return True if card is able to be selected
	 */
	public boolean isSelectable() {
		return selectable;
	}

	/**
	 * @return True if card is selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @return ID of card (-1 if not registered)
	 */
	public int getID() {
		int i = -1;
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j) == this) {
				i = j;
				break;
			}
		}
		return i;
	}

	/**
	 * @return Copy of card
	 */
	public Card copy() {
		return new Card(name, false);
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

	/**
	 * Put on a method to create cards
	 * 
	 * @author Alex
	 * 
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface FCGCardInitialization {

	}
}
