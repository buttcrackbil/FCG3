package fcg.city;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fcg.Client;
import fcg.Game;
import fcg.panels.LabelButton;
import fcg.panels.ScrollablePanel;
import fcg.travel.Travel;

@SuppressWarnings({ "javadoc", "serial" })
public class Menu extends ScrollablePanel {

	protected static LabelButton travel = new LabelButton("Travel",
			new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					Game.frame.remove(Client.getCity());
					Travel travel = new Travel();
					Game.frame.add(travel);
					Game.frame.repaint();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {

				}

				@Override
				public void mouseExited(MouseEvent arg0) {

				}

				@Override
				public void mousePressed(MouseEvent arg0) {

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {

				}
			});

	protected static LabelButton shop = new LabelButton("Shop",
			new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("Clicked shop");
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});

	protected static LabelButton workBench = new LabelButton("Workbench",
			new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("Clicked Workshop");
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});

	public Menu(LabelButton... buttons) {
		super(Game.frame.getWidth() / 15, Game.frame.getHeight(), buttons);
		setLocation(Game.frame.getWidth() - getWidth(), 0);
	}

	@Override
	protected void addComponents(JPanel panel, Component... components) {
		panel.setBackground(Color.BLUE);
		panel.setPreferredSize(new Dimension(getWidth() - 5,
				components.length * 125));
		for (int i = 0; i < components.length; i++) {
			components[i].setLocation(
					(getWidth() - components[i].getWidth()) / 2,
					(i * Game.buttonSize) + ((i + 1) * 25));
			panel.add(components[i]);
		}
		repaint();
	}
}
