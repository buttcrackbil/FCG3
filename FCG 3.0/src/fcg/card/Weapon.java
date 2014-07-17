package fcg.card;

import java.awt.Color;
import java.awt.Graphics;

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
	 * @param picture
	 *            Picture to be displayed on card
	 * @param descriptionLines
	 *            Description of card
	 */
	public Weapon(String name, boolean register, int par1, String picture,
			String... descriptionLines) {
		super(name, picture, register, descriptionLines);
		damage = par1;
	}

	/**
	 * @return Damage of card
	 */
	public int getDamage() {
		return damage;
	}

	@Override
	public Card copy() {
		return new Weapon(getName(), false, damage, picString, description);
	}

	@Override
	public void addComponents(Graphics g, int borderWidth) {
		g.setColor(Color.GRAY);
		g.drawString("Damage: " + damage, borderWidth * 2, getHeight()
				- borderWidth * 2);
	}
}
