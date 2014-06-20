package fcg.card;

import java.awt.Color;
import java.awt.Graphics;

import fcg.Game;
import fcg.listeners.ClickedListener;
import fcg.listeners.DragListener;
import fcg.panels.Bar;

/**
 * Card that has health and attack
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class LivingCard extends Card {

	private int health;

	private int damaged;

	private int attack;

	/**
	 * Creature card
	 * 
	 * @param par1
	 *            Name of card
	 * @param par2
	 *            Health of card
	 * @param par3
	 *            Attack of card
	 * @param picture
	 *            Picture to be shown in background
	 * @param descriptionLines
	 *            The description must be broken into parts to fit on card
	 */
	public LivingCard(String par1, int par2, int par3, String picture,
			String... descriptionLines) {
		super(par1);
		health = par2;
		attack = par3;
		description = descriptionLines;
	}

	/**
	 * Health of card
	 * 
	 * @return Int of health
	 */
	public int getHealth() {
		return health - damaged;
	}

	/**
	 * Attack of card
	 * 
	 * @return Int of attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Takes health away from the card
	 * 
	 * @param i
	 *            Damage done to card
	 */
	public void hurt(int i) {
		if (damaged + i > health) {
			damaged = health;
		} else {
			damaged += i;
		}
		repaint();
	}

	/**
	 * Adds health to the card
	 * 
	 * @param i
	 *            Health gained by the card
	 */
	public void heal(int i) {
		if (damaged - i < 0) {
			damaged = 0;
		} else {
			damaged -= i;
		}
		repaint();
	}

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
		Bar.drawBar(g, 0, getHeight() - 30, Color.BLUE, Color.RED, health,
				health - damaged);
		g.drawString(getName(), offset, 10 + offset);
		for (int i = 0; i < description.length; i++) {
			if (description[i] != null) {
				drawLine(this, g, description[i]);
			}
		}
		stringAttempt = 0;
		lines = 0;
		g.drawString("Attack: " + attack, offset, getHeight() - offset);
	}
}
