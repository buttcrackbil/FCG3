package fcg;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fcg.city.City;
import fcg.listeners.FrameListener;
import fcg.listeners.MainListener;
import fcg.panels.LabelButton;
import fcg.quest.Quest;
import fcg.quest.Task;

/**
 * Main frame
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class Game extends JFrame {

	@SuppressWarnings("javadoc")
	public static Game frame = new Game();

	@SuppressWarnings("javadoc")
	public static JPanel panel;

	@SuppressWarnings("javadoc")
	public static int buttonSize;

	@SuppressWarnings("javadoc")
	public static LabelButton quit;

	@SuppressWarnings("javadoc")
	public static LabelButton singlePlayer;

	@SuppressWarnings("javadoc")
	public static LabelButton multiPlayer;

	@SuppressWarnings("javadoc")
	public static LabelButton switchUser;

	@SuppressWarnings("javadoc")
	public static int cardWidth;

	@SuppressWarnings("javadoc")
	public static int cardHeight;

	@SuppressWarnings("javadoc")
	public static Quest questTest = new Quest(City.cities[0], "Quest Test",
			new Task(City.cities[1]));

	/**
	 * Makes a full screen frame with no decoration
	 */
	public Game() {
		setLayout(null);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Fallout Card Game");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addMouseListener(new FrameListener());
		buttonSize = getSize().width / 20;
	}

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		quit = new LabelButton("Quit", new MainListener());
		singlePlayer = new LabelButton("Single Player", new MainListener());
		singlePlayer.resizeFont();
		multiPlayer = new LabelButton("Multiplayer", new MainListener());
		multiPlayer.setFont(LabelButton.font);
		switchUser = new LabelButton("Switch User", new MainListener());
		switchUser.setFont(LabelButton.font);
		cardWidth = frame.getWidth() / 8;
		cardHeight = frame.getWidth() / 5;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setBackground(Color.BLUE);
		quit.setLocation(0, frame.getHeight() - buttonSize);
		singlePlayer.setLocation(frame.getWidth() - buttonSize, 0);
		multiPlayer.setLocation(frame.getWidth() - buttonSize, buttonSize + 10);
		switchUser.setLocation(frame.getWidth() - buttonSize,
				(buttonSize + 10) * 2);
		panel.add(quit);
		panel.add(singlePlayer);
		panel.add(multiPlayer);
		panel.add(switchUser);
		frame.add(panel);
		if (Client.getName() == null)
			Client.selectPlayer();
		frame.repaint();
	}
}
