package fcg;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fcg.listeners.FrameListener;
import fcg.listeners.MainListener;
import fcg.panels.LabelButton;

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
	public static int cardWidth;

	@SuppressWarnings("javadoc")
	public static int cardHeight;

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
	}

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		quit = new LabelButton("Quit", new MainListener());
		singlePlayer = new LabelButton("Single Player", new MainListener());
		multiPlayer = new LabelButton("Multiplayer", new MainListener());
		cardWidth = frame.getWidth() / 8;
		cardHeight = frame.getWidth() / 5;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setBackground(Color.BLUE);
		quit.setLocation(0, frame.getHeight() - (frame.getWidth() / 20));
		singlePlayer.setLocation(frame.getWidth() - (frame.getWidth() / 20), 0);
		multiPlayer.setLocation(frame.getWidth() - (frame.getWidth() / 20),
				(frame.getWidth() / 20) + 10);
		panel.add(quit);
		panel.add(singlePlayer);
		panel.add(multiPlayer);
		frame.add(panel);
		if (Client.getName() == null)
			Client.selectPlayer();
		frame.repaint();
	}
}
