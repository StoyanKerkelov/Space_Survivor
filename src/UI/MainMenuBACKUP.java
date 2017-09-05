package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenuBACKUP extends JFrame {

	// booleans for status check
	
	private final int WINDOW_HEIGHT = 768;
	private final int WINDOW_WIDTH = 1280;
	String b_startGame_I = "src/res/Button_PlayGame.png";
	String b_scoreScreen_I = "src/res/Button_Scores.png";
	String b_exit_I = "src/res/Button_Exit.png";
	
    
    public MainMenuBACKUP() {
    	
    	
        super("Space Survivor");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        
        //JPanel main
        JPanel main = new JPanel() {
			public boolean isOptimizedDrawingEnabled() {
				return false;
			}
		};
		
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		
        		//add buttons to JPanel main
        
 		JButton b_startGame = new JButton("Start Game");
        //b_startGame.setBorder(null);
        //b_startGame.setContentAreaFilled(false); 
        b_startGame.setMaximumSize(new java.awt.Dimension(250, 80));
        b_startGame.setPreferredSize(new java.awt.Dimension(250, 80));
        //paintButton(b_startGame, b_startGame_I);
        b_startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        b_startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("start game");
            }
        });
        main.add(b_startGame);
        main.add(Box.createRigidArea(new Dimension(20,20)));
        
        JButton b_scoreScreen = new JButton("Highest Scores");
        b_scoreScreen.setMaximumSize(new java.awt.Dimension(250, 80));
        b_scoreScreen.setPreferredSize(new java.awt.Dimension(250, 80));
        //paintButton(b_scoreScreen,b_scoreScreen_I);
        b_scoreScreen.setAlignmentX(Component.CENTER_ALIGNMENT);
        b_scoreScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("go to scores");
            }
        });
        
        main.add(b_scoreScreen);
        main.add(Box.createRigidArea(new Dimension(20,20)));
        
        JButton b_quit = new JButton("Quit");
        b_quit.setMaximumSize(new java.awt.Dimension(250, 80));
        b_quit.setPreferredSize(new java.awt.Dimension(250, 80));
        //paintButton(b_quit, b_exit_I);
        b_quit.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        //add(mainManu);
        b_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("quit game");
            }
        });
        main.add(b_quit);
        
        //add panel to frame
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 0, 5, 0);
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        
        add(main, c);
        setVisible(true);
    }
    
    
	public void paintButton(JButton b, String imagePath){
		try {
			b.setIcon(new ImageIcon(imagePath));
        }catch (Exception ex) {
        	System.out.println(ex);
        	System.out.println("Where is the button image?");
        }
	}
}

