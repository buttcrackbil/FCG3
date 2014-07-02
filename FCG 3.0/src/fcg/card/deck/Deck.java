package fcg.card.deck;

import java.util.ArrayList;

import fcg.card.Card;

/**
 * User's collection of cards
 * 
 * @author Alex
 * 
 */
public class Deck {

	ArrayList<Card> list = new ArrayList<Card>();

	/**
	 * Adds card to the player's deck
	 * 
	 * @param cardID
	 *            ID of the card
	 */
	public void addCard(int cardID) {
		list.add(Card.list.get(cardID));
	}
}
