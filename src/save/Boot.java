package save;


import java.awt.EventQueue;

import javax.swing.JFrame;

public class Boot {

	public static void main(String[] args) {

		// set game frame
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Screen bootFrame = new Screen();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
