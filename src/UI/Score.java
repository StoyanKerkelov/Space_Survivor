package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Score extends JFrame {

	private final int WINDOW_HEIGHT = 768;
	private final int WINDOW_WIDTH = 1280;
	String scoreBackground = "src/res/score_background.png";
	String b_returnToMain_I = "src/res/Button_returnToMain.png";

	Score() {
		super("Space Survivor");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setContentPane(new BackgroundImage(scoreBackground));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton returnToMain = new JButton();

		returnToMain.setBorder(null);
		returnToMain.setContentAreaFilled(false);
		returnToMain.setBounds(960, 600, 250, 80);
		
		returnToMain.setIcon(new ImageIcon(b_returnToMain_I));

		returnToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Return to main");;
            }
        });
		
		returnToMain.setLayout(null);//always set button by absolute 
		add(returnToMain);
		setVisible(true);
	}
}
