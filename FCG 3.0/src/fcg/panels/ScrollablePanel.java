package fcg.panels;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Creates a panel that anything can be added to and scrolled through
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class ScrollablePanel extends JPanel {

	/**
	 * @param i
	 *            Width of panel
	 * @param j
	 *            Height of panel
	 * @param par1
	 *            All components being added to panel
	 */
	public ScrollablePanel(int i, int j, Component... par1) {
		setSize(i, j);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		addComponents(panel, par1);
		JScrollPane sp = new JScrollPane(panel);
		sp.setSize(i + 10, j + 10);
		sp.setLocation(-5, -5);
		sp.getHorizontalScrollBar().setVisible(false);
		add(sp);
	}

	protected void addComponents(JPanel panel, Component... components) {
		System.out.println("Add Components Method not overridden");
	}
}
