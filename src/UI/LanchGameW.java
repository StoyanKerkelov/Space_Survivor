package UI;

import java.awt.EventQueue;

public class LanchGameW {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameW runGame = new GameW();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}