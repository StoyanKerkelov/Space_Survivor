package Examples;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MyMenuFrame extends JFrame {

	public MyMenuFrame() throws HeadlessException {
		super("My Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(new JLabel("Hi there"), BorderLayout.PAGE_START);
		this.setVisible(true);
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");

		menu.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				System.out.println("a");

			}

			@Override
			public void menuDeselected(MenuEvent e) {
				System.out.println("a");

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				System.out.println("a");

			}
		});
		menubar.add(menu);
		this.setJMenuBar(menubar);
	}

	public static void main(String[] args) {
		new MyMenuFrame();
	}
}