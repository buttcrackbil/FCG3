package fcg.content;

import fcg.card.Card.FCGCardInitialization;
import fcg.card.LivingCard;
import fcg.city.City;
import fcg.city.City.FCGCityInitialization;
import fcg.city.debugcity.DebugCity;

/**
 * Main content of the game
 * 
 * @author Alex
 * 
 */
@Content
public class MainContent {

	// Cards

	@SuppressWarnings("javadoc")
	public static LivingCard RIFLEMAN;
	@SuppressWarnings("javadoc")
	public static LivingCard SOLDIER;

	// Cities

	@SuppressWarnings("javadoc")
	public static City DEBUG_CITY;

	/**
	 * Creates cards
	 */
	@FCGCardInitialization
	public static void createCards() {
		SOLDIER = new LivingCard("Soldier", true, 5, 3,
				"fcg/images/picture.png", "Basic soldier");
		RIFLEMAN = new LivingCard("Rifleman", true, 5, 5,
				"fcg/images/picture.png", "Basic rifleman");
	}

	/**
	 * Creates cities
	 */
	@FCGCityInitialization
	public static void createCities() {
		DEBUG_CITY = new DebugCity();
	}
}