package Examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuPanel extends JFrame {
	JMenuBar mbar;
	JMenu menu;
	JPanel jp;
	JTextField jc;
	JButton jb;

	public MenuPanel() {
		setTitle("Menu Panel");
		setSize(400, 400);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Create menubar
		mbar = new JMenuBar();

		// Create menu
		menu = new JMenu("Menu");

		// Create JPanel
		jp = new JPanel();

		// Create JTextField with capacity of 20 chars to show
		jc = new JTextField(20);

		// Create JButton with text Set
		jb = new JButton("Set");

		// Add JTextField jc to JPanel
		jp.add(jc);

		// Add JButton jb to JPanel
		jp.add(jb);

		// Add JPanel jp to JMenu
		menu.add(jp);

		// Add menu to menu bar
		mbar.add(menu);

		// Add JMenuBar mbar to JFrame
		add(mbar);

		// Add KeyListener to JTextField jc
		jc.addKeyListener(new KeyAdapter() {

			// Do things when key is pressed
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (ke.getKeyCode() == KeyEvent.VK_DELETE)) {

					// Control enters this if() when user presses either
					// backspace or Delete because these 2 actions could only
					// modify the text.
					if (jc.getText().length() > 0)
						// Set JButton jb enabled. It will be disabled when user
						// clicks on it and enabled when he modifies text.
						jb.setEnabled(true);
				}
			}
		});

		// Add ActionListener to JButton jb
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// Check if text in JTextField length is >0, you can
				// alternatively call isEmpty()
				if (jc.getText().length() > 0) {
					// Set text in JTextArea jc as title of the frame. Title is
					// not set, if jc has no text.
					setTitle(jc.getText());
					// Set JButton jb disabled, so that user may not click on it
					// until the text is modified.
					jb.setEnabled(false);
				}
			}
		});
	}

	public static void main(String args[]) {
		new MenuPanel();
	}
}