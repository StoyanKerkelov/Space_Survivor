

import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

import data.GameBoard;

@SuppressWarnings("serial")
public class RunGame extends JFrame {

	private final int WINDOW_HEIGHT = 768;
	private final int WINDOW_WIDTH = 1024;
	public boolean exitGame = false;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try{
					RunGame executable = new RunGame();
					executable.setVisible(true);
				}catch(Exception e){
		             e.printStackTrace();
		        }
			}
		});
	}

	public RunGame() {
		//create game window
		initWindow();
		//create menu thats redirects to different paths
		if(!exitGame){
			
		} else 
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		
		initGameBoard();
	}
	
	private void initWindow() {

		this.setTitle("Space Survivor");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//initialize game
	private void initGameBoard() {

		add(new GameBoard());

		setResizable(false);
		// The pack method sizes the frame so that all its contents are at or
		// above their preferred sizes
		pack();

		setTitle("Space Survivor");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}