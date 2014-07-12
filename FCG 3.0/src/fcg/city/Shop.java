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
		int rows = components.length / 3;
		if (rows * 3 < components.length) {
			rows++;
		}
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(getWidth() - 5,
				(Game.cardHeight * rows) + (rows * 10)));
		int rowCount = 0;
		int columnCount = 0;
		for (int i = 0; i < components.length; i++) {
			((Card) components[i]).setDraggable(false);
			((Card) components[i]).setSelectable(true);
			components[i].setLocation((columnCount * Game.cardWidth) + 4,
					(((rowCount * Game.cardHeight) + (rowCount * 10))) + 4);
			panel.add(components[i]);
			columnCount++;
			if (columnCount == 3) {
				rowCount++;
				columnCount = 0;
			}
		}
	}
}
