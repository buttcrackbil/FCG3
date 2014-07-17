package fcg.city;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

import fcg.Game;
import fcg.card.Card;
import fcg.panels.ScrollablePanel;

/**
 * Panel to buys cards from in cities
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class Shop extends ScrollablePanel {

	@SuppressWarnings("javadoc")
	public Shop(Card... cards) {
		super(Game.cardWidth * 3, Game.frame.getHeight()
				- (Game.buttonSize * 2), cards);
		setLocation(0, 0);
	}

	@Override
	protected void addComponents(JPanel panel, Component... components) {
		Card[] cards = new Card[components.length];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = ((Card) components[i]).copy();
		}
		int rows = cards.length / 3;
		if (rows * 3 < cards.length) {
			rows++;
		}
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(getWidth() - 5,
				(Game.cardHeight * rows) + (rows * 10)));
		int rowCount = 0;
		int columnCount = 0;
		for (int i = 0; i < cards.length; i++) {
			((Card) cards[i]).setDraggable(false);
			((Card) cards[i]).setSelectable(true);
			cards[i].setLocation((columnCount * Game.cardWidth) + 4,
					(((rowCount * Game.cardHeight) + (rowCount * 10))) + 4);
			panel.add(cards[i]);
			columnCount++;
			if (columnCount == 3) {
				rowCount++;
				columnCount = 0;
			}
		}
	}
}
