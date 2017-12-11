package save;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import concepts.ScoreMenu;

public class Screen extends JFrame {

	private final int WINDOW_HEIGHT = 768;
	private final int WINDOW_WIDTH = 1280;

	private JPanel mainMenu = new JPanel();
	String mainMenuBackground = "src/res/mainMenu_background.png";
	String b_startGame_I = "src/res/Button_PlayGame.png";
	String b_scoreScreen_I = "src/res/Button_Scores.png";
	String b_quit_I = "src/res/Button_Exit.png";

	private JPanel scoreMenu = new JPanel();
	String scoreBackground = "src/res/score_background.png";
	String b_returnToMain_I = "src/res/Button_returnToMain.png";

	private JPanel gameDisplay = new JPanel();
	String gamePanel = "src/res/mainMenu_background.png";
	String GUIPanel = "src/res/mainMenu_background.png";

	
	/* only for testing
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SolidMenu test = new SolidMenu();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
*/
	
	public Screen() {

		super("Space Survivor");
		super.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		super.setResizable(false);
		super.getContentPane().setBackground(Color.BLUE);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initMainPanel();
		initScorePanel();
		initGame();
		addMainMenuPanel();
	}

	public void initMainPanel() {

		// mainMenuPanel
		mainMenu.setOpaque(true); // remove coloring of panel
		mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.PAGE_AXIS));

		JButton b_startGame = new JButton();
		setButton(b_startGame, b_startGame_I, 250, 80);
		b_startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addGamePanel();
			}
		});
		JButton b_scoreScreen = new JButton();
		setButton(b_scoreScreen, b_scoreScreen_I, 250, 80);
		b_scoreScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addScorePanel();
			}
		});
		JButton b_quit = new JButton();
		setButton(b_quit, b_quit_I, 250, 80);
		b_quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quitWindow();
			}
		});
			
		mainMenu.add(b_startGame);
		mainMenu.add(Box.createRigidArea(new Dimension(20, 20)));
		mainMenu.add(b_scoreScreen);
		mainMenu.add(Box.createRigidArea(new Dimension(20, 20)));
		mainMenu.add(b_quit);
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

	public void initGame() {

		gameDisplay.setLayout(new BoxLayout(gameDisplay, BoxLayout.X_AXIS));

		JPanel GUIPanel = new JPanel();
		GUIPanel.setPreferredSize(new Dimension(256, 768));
		GUIPanel.setBackground(Color.GRAY);
		gameDisplay.add(GUIPanel);
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(1024, 768));
		gamePanel.setBackground(Color.BLACK);
		gameDisplay.add(gamePanel);
		gameDisplay.setOpaque(false);
	}
	
	public void initScorePanel() {

		scoreMenu.setBackground(Color.GREEN);

		JButton returnToMain = new JButton();

		returnToMain.setBorder(null);
		returnToMain.setContentAreaFilled(false);
		returnToMain.setBounds(960, 600, 250, 80);

		returnToMain.setIcon(new ImageIcon(b_returnToMain_I));

		returnToMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				addMainMenuPanel();
			}
		});
		
		returnToMain.setLayout(null);// always set button by absolute
		scoreMenu.add(returnToMain);
	}
	
	private void addScorePanel() {
		super.getContentPane().removeAll();
		super.setLayout(null);
		super.setContentPane(scoreMenu);
		super.getContentPane().validate();
		
		super.update(getGraphics());
		super.setVisible(true);
	}
	
	private void addGamePanel() {
		super.getContentPane().removeAll();
		super.setContentPane(gameDisplay);
		super.getContentPane().validate();
		
		super.update(getGraphics());
		super.setVisible(true);
	}
	
	public void addMainMenuPanel(){
		super.getContentPane().removeAll();
		super.setLayout(new GridBagLayout());
		super.getContentPane().add(mainMenu, new GridBagConstraints());
		super.getContentPane().validate();
		
		super.update(getGraphics());
		super.setVisible(true);
	}
	
	private void quitWindow() {
		dispose();
		System.exit(0);
	}
}
