package fcg.card;

import java.awt.Color;
import java.awt.Graphics;

import fcg.Game;
import fcg.listeners.ClickedListener;
import fcg.listeners.DragListener;

/**
 * Creates a weapon card
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class Weapon extends Card {

	private int damage;

	/**
	 * Types of ammo
	 * 
	 * @author Alex
	 * 
	 */
	public enum ammoTypes {
		@SuppressWarnings("javadoc")
		TWENTY_TWO, @SuppressWarnings("javadoc")
		FIFTY, @SuppressWarnings("javadoc")
		NINE, @SuppressWarnings("javadoc")
		TEN
	};

	/**
	 * @param name
	 *            Name of weapon
	 * @param register
	 *            True to register card, false if making card copy
	 * @param par1
	 *            Damage this weapon does
	 * @param descriptionLines
	 *            Description of card
	 */
	public Weapon(String name, boolean register, int par1,
			String... descriptionLines) {
		super(name, register);
		damage = par1;
		description = descriptionLines;
	}

	/**
	 * @return Damage of card
	 */
	public int getDamage() {
		return damage;
	}

	@Override
	public void paint(Graphics g) {
		int offset = 4;
		addMouseMotionListener(new DragListener());
		addMouseListener(new ClickedListener());
		descriptionHeight = getHeight() / 2;
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
		g.drawString("Damage: " + damage, offset, getHeight() - offset);
	}

}
