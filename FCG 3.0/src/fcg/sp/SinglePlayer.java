package fcg.sp;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fcg.Game;

/**
 * Place where all singleplayer things are started
 * 
 * @author Alex
 * 
 */
public class SinglePlayer {

	static JPanel panel;

	static TextField textField;

	static JPanel textPanel;

	protected static File dir = new File(System.getProperty("user.home")
			+ "/Documents/Ball U/FCG");

	/**
	 * Starts singleplayer
	 */
	public static void start() {
		Game.panel.removeAll();
		Game.panel.add(Game.quit);
		Game.panel.repaint();
	}

	/**
	 * Select player panel
	 */
	public static void selectPlayer() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(Game.panel.getWidth() / 3, Game.panel.getHeight() / 3);
		textPanel = new JPanel();
		textPanel.setSize(200, 21);
		textPanel.setLocation((panel.getWidth() - textPanel.getWidth()) / 2,
				panel.getHeight() - ((panel.getHeight() / 10) * 2));
		textField = new TextField("", 100);
		textField.setSize(200, 21);
		textField.setLocation(0, 0);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				createUser(textField.getText());
			}

		});
		textPanel.add(textField);
		int buttonHeight = panel.getHeight() / 10;
		int buttonWidth = panel.getWidth() / 4;
		MouseListener ml = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel label = (JLabel) arg0.getSource();
				switch (label.getText()) {
				case "Cancel":
					Game.panel.remove(panel);
					Game.panel.repaint();
					break;
				case "Accept":
					if (UserLabel.selected != null) {
						System.out.println(UserLabel.selected.getText());
					}
					break;
				case "Create New User":
					panel.add(textPanel);
					panel.repaint();
					break;
				case "Delete User":
					if (UserLabel.selected != null) {
						deleteUser(UserLabel.selected.getText());
					}
					break;
				}
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
		};
		panel.setBackground(Color.RED);
		panel.setLocation((Game.panel.getWidth() - panel.getWidth()) / 2,
				(Game.panel.getHeight() - panel.getHeight()) / 2);
		JLabel accept = new JLabel("Accept");
		accept.setForeground(Color.WHITE);
		accept.setHorizontalAlignment(SwingConstants.CENTER);
		accept.setSize(buttonWidth, buttonHeight);
		accept.setLocation(panel.getWidth() - accept.getWidth(),
				panel.getHeight() - accept.getHeight());
		JLabel decline = new JLabel("Cancel");
		decline.setForeground(Color.WHITE);
		decline.setHorizontalAlignment(SwingConstants.CENTER);
		decline.setSize(buttonWidth, buttonHeight);
		decline.setLocation(0, panel.getHeight() - decline.getHeight());
		JLabel newUser = new JLabel("Create New User");
		newUser.setForeground(Color.WHITE);
		newUser.setHorizontalAlignment(SwingConstants.CENTER);
		newUser.setSize(buttonWidth, buttonHeight);
		newUser.setLocation(buttonWidth,
				panel.getHeight() - buttonHeight);
		JLabel deleteUser = new JLabel("Delete User");
		deleteUser.setHorizontalAlignment(SwingConstants.CENTER);
		deleteUser.setSize(buttonWidth, panel.getHeight() / 10);
		deleteUser.setLocation(buttonWidth * 2, panel.getHeight()
				- buttonHeight);
		deleteUser.setForeground(Color.WHITE);
		Users users = new Users(panel.getWidth(), buttonHeight * 9,
				getUsers());
		users.setLocation(0, 0);
		accept.addMouseListener(ml);
		decline.addMouseListener(ml);
		newUser.addMouseListener(ml);
		deleteUser.addMouseListener(ml);
		panel.add(newUser);
		panel.add(accept);
		panel.add(decline);
		panel.add(deleteUser);
		panel.add(users);
		Game.panel.add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		Game.panel.repaint();
	}

	private static String[] getUsers() {
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String[] directories = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		return directories;
	}

	private static void deleteUser(String user) {
		File newDir = new File(dir + "/" + user);
		newDir.delete();
		Game.panel.remove(panel);
		Game.panel.repaint();
		selectPlayer();
	}

	private static void createUser(String user) {
		File newDir = new File(dir + "/" + user);
		newDir.mkdir();
		Game.panel.remove(panel);
		Game.panel.repaint();
		selectPlayer();
	}
}
