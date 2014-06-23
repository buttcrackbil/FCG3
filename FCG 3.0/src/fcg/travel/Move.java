package fcg.travel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import fcg.Game;
import fcg.city.City;

/**
 * Panel shown between city movements
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class Move extends JPanel {

	@SuppressWarnings("unused")
	private int days;

	private TravelBar bar;

	protected City city;

	@SuppressWarnings("javadoc")
	public Move(int days, City city) {
		this.days = days;
		this.city = city;
		setSize(Game.frame.getWidth(), Game.frame.getHeight());
		setLocation(0, 0);
		setBackground(Color.BLUE);
		JButton go = new JButton("Go");
		go.setSize(100, 20);
		go.setLocation(getWidth() - go.getWidth(), getHeight() - go.getHeight());
		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bar.spendDay()) {
					checkOutcome();
				}
			}
		});
		bar = new TravelBar(days, 0, this);
		add(bar);
		add(go);
	}

	private void checkOutcome() {
		int min = 1;
		int max = 4;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		switch (randomNum) {
		case 1:
			System.out.println("Got a one");
			break;
		case 2:
			System.out.println("Got a two");
			break;
		case 3:
			System.out.println("Got a three");
			break;
		case 4:
			System.out.println("Got a four");
			break;
		}
	}
}
