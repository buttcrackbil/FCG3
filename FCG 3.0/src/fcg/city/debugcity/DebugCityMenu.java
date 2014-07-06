package fcg.city.debugcity;

import fcg.city.Menu;
import fcg.panels.LabelButton;

/**
 * Menu for Debug City
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class DebugCityMenu extends Menu {

	protected static LabelButton[] buttons = { travel, shop, workBench };

	@SuppressWarnings("javadoc")
	public DebugCityMenu() {
		super(buttons);
	}
}
