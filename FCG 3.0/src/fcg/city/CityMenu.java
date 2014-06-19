package fcg.city;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fcg.Game;
import fcg.panels.LabelButton;
import fcg.travel.Travel;

@SuppressWarnings("serial")
class CityMenu extends JPanel {

	private LabelButton travel;

	private LabelButton shop;

	private LabelButton workBench;

	private int choiceAmount = 0;

	protected CityMenu() {
		setSize(Game.frame.getWidth() / 15, Game.frame.getHeight());
		setLocation(Game.frame.getWidth() - getWidth(), 0);
		setLayout(null);
		setOpaque(false);
		travel = new LabelButton("Travel", new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Game.frame.remove((City) getParent());
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
		travel.setLocation(getWidth() - Game.buttonSize, (Game.buttonSize + 10)
				* choiceAmount);
		travel.setFont(LabelButton.font);
		choiceAmount++;
		shop = new LabelButton("Shop", null);
		shop.setLocation(getWidth() - Game.buttonSize, (Game.buttonSize + 10)
				* choiceAmount);
		shop.setFont(LabelButton.font);
		choiceAmount++;
		workBench = new LabelButton("Workbench", null);
		workBench.setLocation(getWidth() - Game.buttonSize,
				(Game.buttonSize + 10) * choiceAmount);
		workBench.setFont(LabelButton.font);
		choiceAmount++;
		add(travel);
		add(shop);
		add(workBench);
	}

	protected void addChoice(LabelButton button) {
		button.setLocation(getWidth() - Game.buttonSize, (Game.buttonSize + 10)
				* choiceAmount);
		add(button);
		choiceAmount++;
		repaint();
	}
}
