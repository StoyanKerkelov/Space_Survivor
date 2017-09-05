package UI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowManager {

	// booleans for status check

	// window
	JFrame window = new JFrame("This is the game window");

	// panels
	JPanel mainMenu = new JPanel();

	JPanel scoreScreen = new JPanel();

	JPanel gamePanel = new JPanel();
	JPanel UIPanel = new JPanel();

	// panel insides
	JButton b_startGame = new JButton("start new game");
	JButton b_scoreScreen = new JButton("view score screen");
	JButton b_quit = new JButton("quit game");
	JButton b_returnToMain = new JButton("return to main menu");
	
	JLabel text = new JLabel("Button works!");

	WindowManager() {

		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);

		mainMenu.setBackground(Color.CYAN);
		window.add(mainMenu, BorderLayout.CENTER);
		scoreScreen.setBackground(Color.GRAY);
		window.add(scoreScreen, BorderLayout.PAGE_END);

		mainMenu.add(b_startGame);
		mainMenu.add(b_scoreScreen);
		mainMenu.add(b_quit);

		text.setForeground(Color.WHITE);
		scoreScreen.add(text);
		text.setVisible(false);

		window.setVisible(true);
	}

	// game panel
	protected void initGame() {

	}

	// score panel
	protected void lookScoreMenu() {

	}

	// main menu
	protected void returnToMainMenu() {

	}

	protected void quitWindow() {
		window.dispose();
		System.exit(0);
	}
}
