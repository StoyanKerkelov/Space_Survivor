package UI;

import java.awt.EventQueue;

public class LanchMainMenu {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Window gui = new Window();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
