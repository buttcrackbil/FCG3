package fcg.content;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import fcg.card.Card.FCGCardInitialization;
import fcg.city.City.FCGCityInitialization;

/**
 * Class for checking if annotation is present in passed class
 * 
 * @author Alex
 * 
 */
public class LoadContent {

	/**
	 * @param c
	 *            Class to be checked for annotation
	 */
	public static void runContent() {
		if (MainContent.class.isAnnotationPresent(Content.class)) {
			Method[] m = MainContent.class.getMethods();
			for (int i = 0; i < m.length; i++) {
				if (m[i].isAnnotationPresent(FCGCardInitialization.class)
						|| m[i].isAnnotationPresent(FCGCityInitialization.class)) {
					try {
						m[i].invoke(null);
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}