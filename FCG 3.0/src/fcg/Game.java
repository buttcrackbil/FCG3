package fcg;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main frame
 * 
 * @author Alex
 * 
 */
@SuppressWarnings("serial")
public class Game extends JFrame {

	@SuppressWarnings("javadoc")
	public static Game frame;

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
	 * For testing purposes
	 */
	public static LivingCard card;

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
		frame = new Game();
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
		card = new LivingCard("Debug Card", 100, 10, "pic.png", new String[]{
				"Description"
		});
		panel.add(quit);
		panel.add(singlePlayer);
		panel.add(multiPlayer);
		panel.add(card);
		frame.add(panel);
	}

	@Override
	public void paint(Graphics g) {
		cardWidth = frame.getWidth() / 8;
		cardHeight = frame.getWidth() / 5;
		if (frame != null && panel != null) {
			panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
			quit.setLocation(0, frame.getHeight() - (frame.getWidth() / 20));
			singlePlayer.setLocation(
					frame.getWidth() - (frame.getWidth() / 20), 0);
			multiPlayer.setLocation(frame.getWidth() - (frame.getWidth() / 20),
					(frame.getWidth() / 20) + 10);
			panel.repaint();
			quit.repaint();
			singlePlayer.repaint();
			multiPlayer.repaint();
		}
	}
}
