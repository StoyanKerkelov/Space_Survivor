package CopyOf2;

import javax.swing.JFrame;


public class Boot {

	public static void main(String[] args){
		Game game = new Game();
		
		JFrame window = new JFrame("Space Survivor");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.add(game);
		//setting size by game
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
}
