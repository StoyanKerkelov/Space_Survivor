package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame {

	// write here booleans for status check

	private final int WINDOW_HEIGHT = 768;
	private final int WINDOW_WIDTH = 1280;

	public Window() {
		super("Space Survivor");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		getContentPane().setBackground(Color.BLUE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// initialize new window with main menu panel
		Main main = new Main();
		
		getContentPane().add(main, BorderLayout.CENTER);
		update(getGraphics());
		
		setVisible(true);
	}

}
// PANELS

class Main extends JPanel {

	JPanel mainMenuPanel;

	String mainMenuBackground = "src/res/mainMenu_background.png";
	String b_startGame_I = "src/res/Button_PlayGame.png";
	String b_scoreScreen_I = "src/res/Button_Scores.png";
	String b_quit_I = "src/res/Button_Exit.png";

	Main() {

		mainMenuPanel = new JPanel();
		
		mainMenuPanel.setPreferredSize(new Dimension(800, 768));
		mainMenuPanel.setBackground(Color.RED);
		
		
		ImageIcon image = new ImageIcon(mainMenuBackground);
		JLabel label = new JLabel("", image, JLabel.CENTER);
		mainMenuPanel.add(label, BorderLayout.CENTER );
		
		
		/*
		
		//mainMenuPanel.
		//.setContentPane(new BackgroundImage(mainMenuBackground));

		JPanel buttons = new JPanel();
		
		JPanel buttons = new JPanel() {
			public boolean isOptimizedDrawingEnabled() {
				return false;
			}
		};
		
		
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.setOpaque(false); // remove coloring of panel

		// crate buttons
		JButton b_startGame = new JButton();
		setButton(b_startGame, b_startGame_I, 250, 80);
		b_startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});

		JButton b_scoreScreen = new JButton();
		setButton(b_scoreScreen, b_scoreScreen_I, 250, 80);
		b_scoreScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goToScore();
			}
		});

		JButton b_quit = new JButton();
		setButton(b_quit, b_quit_I, 250, 80);
		b_quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		//		quitWindow();
			}
		});

		// add buttons to panel
		buttons.add(b_startGame);
		buttons.add(Box.createRigidArea(new Dimension(20, 20)));
		buttons.add(b_scoreScreen);
		buttons.add(Box.createRigidArea(new Dimension(20, 20)));
		buttons.add(b_quit);

		// add panel to frame
		
		mainMenuPanel.add(buttons);
		
		*/
	}

	public void setButton(JButton b, String imagePath, int buttonWidth, int buttonHeight) {
		b.setBorder(null);
		b.setContentAreaFilled(false);
		b.setMaximumSize(new java.awt.Dimension(buttonWidth, buttonHeight));
		b.setPreferredSize(new java.awt.Dimension(buttonWidth, buttonHeight));
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		paintButton(b, imagePath);
	}

	public void paintButton(JButton b, String imagePath) {
		try {
			b.setIcon(new ImageIcon(imagePath));
		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("Where is the button image?");
		}
	}

	protected void goToScore() {

		//getContentPane().removeAll();
		// initScorePanel();
		// getContentPane().add(scorePanel);
		update(getGraphics());

	}

	/*
	protected void quitWindow() {
		
		dispose();
		System.exit(0);
	}
	*/

	protected void startGame() {
		// set Game window
		// set GUI window
		// start clock
		// start loop

	}

	class ScorePanel extends JPanel {

		JPanel scorePanel;
		String scoreBackground = "src/res/score_background.png";
		String b_returnToMain_I = "src/res/Button_returnToMain.png";

		ScorePanel() throws IOException {

			scorePanel = new JPanel();

			JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File(scoreBackground))));

			label.setLayout(new BorderLayout());
			// scorePanel.setContentPane(label);

			JButton returnToMain = new JButton();

			returnToMain.setBorder(null);
			returnToMain.setContentAreaFilled(false);
			returnToMain.setBounds(960, 600, 250, 80);

			returnToMain.setIcon(new ImageIcon(b_returnToMain_I));

			returnToMain.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					returnToMainMenu();
					;
				}
			});

			returnToMain.setLayout(null);// always set button by absolute
			// scorePanel.add(returnToMain);

		}

		protected void returnToMainMenu() {
			// return to Main panel
		}
	}

	class GamePanel extends JPanel {

		JPanel gamePanel, gameGUIPanel;

		GamePanel() {

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

			//getContentPane().add(display);
		}
	}
}
