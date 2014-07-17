package fcg.card;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Creates an armor card
 * 
 * @author Alex
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
	 * @param picture
	 *            Picture to be displayed on card
	 * @param descriptionLines
	 *            Description of card
	 */
	public Armor(String name, boolean register, int par1, String picture,
			String... descriptionLines) {
		super(name, picture, register, descriptionLines);
		armor = par1;
	}

	/**
	 * @return Defense of card
	 */
	public int getDefense() {
		return armor;
	}

	@Override
	public Card copy() {
		return new Armor(getName(), false, armor, picString, description);
	}

	@Override
	public void addComponents(Graphics g, int borderWidth) {
		g.setColor(Color.GRAY);
		g.drawString("Defense: " + armor, borderWidth * 2, getHeight()
				- borderWidth * 2);
	}

}
