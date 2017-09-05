package UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameW extends JFrame {

	private final int WINDOW_HEIGHT = 768;
	private final int WINDOW_WIDTH = 1280;

	String gamePanel = "src/res/mainMenu_background.png";
	String GUIPanel = "src/res/mainMenu_background.png";

	GameW() {

		super("Space Survivor");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel display = new JPanel();
		display.setLayout(new BoxLayout(display, BoxLayout.X_AXIS));

		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(1024, 768));
		gamePanel.setBackground(Color.BLACK);
		
		JPanel GUIPanel = new JPanel();
		GUIPanel.setPreferredSize(new Dimension(256, 768));
		GUIPanel.setBackground(Color.GRAY);

		display.add(GUIPanel);
		display.add(gamePanel);

		getContentPane().add(display);
		setVisible(true);
	}
}
