package fcg.content;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
	@SuppressWarnings("rawtypes")
	public static void runContent(Object c) {
		Method[] m = ((Class) c).getMethods();
		for (int i = 0; i < m.length; i++) {
			if (m[i].isAnnotationPresent(Content.class)) {
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