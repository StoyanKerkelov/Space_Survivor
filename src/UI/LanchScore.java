package UI;

import java.awt.EventQueue;

public class LanchScore {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Score list = new Score();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
