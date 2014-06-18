package fcg.city;

import java.awt.Color;

import javax.swing.JPanel;

import fcg.Game;
import fcg.panels.LabelButton;

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
		setBackground(Color.BLUE);
		travel = new LabelButton("Travel", null);
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
