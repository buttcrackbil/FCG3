package fcg.card;

import java.awt.Color;
import java.awt.Graphics;

import fcg.Game;
import fcg.listeners.ClickedListener;
import fcg.listeners.DragListener;

/**
 * Creates an armor card
 * 
 * @author A1C Ballou
 * 
 */
@SuppressWarnings("serial")
public class Armor extends Card {

	private int armor;

	/**
	 * @param name
	 *            Name of card
	 * @param register
	 *            True to register card, false if making card copy
	 * @param par1
	 *            Defense of card
	 * @param descriptionLines
	 *            Description of card
	 */
	public Armor(String name, boolean register, int par1,
			String... descriptionLines) {
		super(name, register);
		armor = par1;
		description = descriptionLines;
	}

	/**
	 * @return Defense of card
	 */
	public int getDefense() {
		return armor;
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
		g.drawString(getName(), offset, 10 + offset);
		for (int i = 0; i < description.length; i++) {
			if (description[i] != null) {
				drawLine(this, g, description[i]);
			}
		}
		stringAttempt = 0;
		lines = 0;
		g.drawString("Defense: " + armor, offset, getHeight() - offset);
	}

}
