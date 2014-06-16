package fcg.sp;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Panel that contains a scroll pane with all users
 * 
 * @author Alex
 *
 */
@SuppressWarnings("serial")
public class Users extends JPanel {

	/**
	 * A scroll pane with all users
	 * 
	 * @param i Width of pane
	 * @param j Height of pane
	 * @param strings User Names
	 */
	public Users(int i, int j, String... strings) {
		setSize(i, j);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(getWidth() - 25,
				strings.length * 50));
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		UserLabel[] labels = new UserLabel[strings.length];
		if (labels.length > 0) {
			for (int x = 0; x < strings.length; x++) {
				labels[x] = new UserLabel(strings[x]);
				labels[x].setLocation(0, x * 50);
				panel.add(labels[x]);
			}
		}else if(labels.length == 0){
			JLabel label = new JLabel("No Users. Create New User");
			label.setLocation(0, 0);
			label.setSize(getWidth(), 50);
			panel.add(label);
		}
		JScrollPane sp = new JScrollPane(panel);
		sp.setPreferredSize(new Dimension(getSize().width - 4, getSize().height));
		sp.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		sp.getVerticalScrollBar().setUnitIncrement(16);
		setBackground(Color.RED);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		sp.setLocation(0, 0);
		add(sp);
	}
}
