package fcg.panels;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import fcg.Game;

/**
 * Clickable label
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class LabelButton extends JLabel {

	@SuppressWarnings("javadoc")
	public String string;

	private int size = Game.frame.getSize().width / 20;

	/**
	 * Constructor
	 * 
	 * @param text
	 *            Text to be displayed
	 * @param listener
	 *            Listener that this label will fire in
	 */
	public LabelButton(String text, MouseListener listener) {
		string = text;
		addMouseListener(listener);
		setSize(size, size);
		setOpaque(true);
	}

	@Override
	public void paint(Graphics g) {
		size = Game.frame.getSize().width / 20;
		setSize(size, size);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GREEN);
		g.fillRect(2, 2, getWidth() - 4, getHeight() - 4);
		g.setColor(Color.BLACK);
		FontMetrics fm = g.getFontMetrics(getFont());
		int textLength = fm.stringWidth(string);
		g.drawString(string, (getWidth() - textLength) / 2, getHeight() - 6);
	}
}