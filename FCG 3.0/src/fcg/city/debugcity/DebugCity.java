package fcg.city.debugcity;

import fcg.city.City;
import fcg.city.Menu;

/**
 * Debug City
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class DebugCity extends City {

	@SuppressWarnings("javadoc")
	public DebugCity() {
		super("Debug City", 250, 250);
	}

	@Override
	protected Menu cityMenu() {
		return new DebugCityMenu();
	}

}
