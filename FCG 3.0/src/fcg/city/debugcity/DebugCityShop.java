package fcg.city.debugcity;

import fcg.card.Card;
import fcg.city.Shop;
import fcg.content.MainContent;

/**
 * Shop for Debug City
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class DebugCityShop extends Shop {

	private static Card[] cards = { MainContent.RIFLEMAN.copy(),
			MainContent.SOLDIER.copy(), MainContent.RIFLEMAN.copy(),
			MainContent.SOLDIER.copy() };

	@SuppressWarnings("javadoc")
	public DebugCityShop() {
		super(cards);
	}
}
