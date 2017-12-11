package save;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Using JPanel to draw Swing JFrame is the window frame, it can have one or
 * more JPanel instances inside it. JPanel is not the window.
 */

@SuppressWarnings("serial")
public class GameBoard extends JPanel implements ActionListener {

	private Timer timer;
	private SpaceShip craft;
	private ArrayList<Asteroid> aliens;
	private boolean ingame;
	private final int B_WIDTH = 1024;	//400
	private final int B_HEIGHT = 768;	//300
	private final int ICRAFT_X = 40;
	private final int ICRAFT_Y = B_WIDTH / 2;
	private final int DELAY = 10; // ms

	// x, y start coordinates for aliens
	private final int[][] pos = {
		    {2380, 29}, {2500, 59}, {1380, 89},
		    {780, 109}, {580, 139}, {680, 239},
		    {790, 259}, {760, 50}, {790, 150},
		    {980, 209}, {560, 45}, {510, 70},
		    {930, 159}, {590, 80}, {530, 60},
		    {940, 59}, {990, 30}, {920, 200},
		    {900, 259}, {660, 50}, {540, 90},
		    {810, 220}, {860, 20}, {740, 180},
		    {820, 128}, {490, 170}, {700, 30}
		};
	public GameBoard() {

		initBoard();
	}

	private void initBoard() {

		// key listener
		addKeyListener(new TAdapter());
		/**
		 * Events are only dispatched to the component that has focus. So your
		 * KeyEvent will only be dispatched to the panel if it is "focusable"
		 * and it has focus.
		 */
		setFocusable(true);

		setBackground(Color.BLACK);
		// Sets whether the this component should use a buffer to paint.
		
		ingame = true;

		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
		craft = new SpaceShip(ICRAFT_X, ICRAFT_Y);

		initAliens();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	private void initAliens() {

		aliens = new ArrayList<>();

		for (int[] p : pos) {
			aliens.add(new Asteroid(p[0], p[1]));
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (ingame) {
			drawObjects(g);
		} else {
			drawGameOver(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}

	private void drawObjects(Graphics g) {

		// draw Spaceship
		if (craft.isVisible()) {
			g.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
		}

		// draw existing missiles
		ArrayList<Projectile> ms = craft.getMissiles();

		for (Projectile m : ms) {
			if (m.isVisible()) {
				g.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}
		}

		// draw alive missiles

		for (Asteroid a : aliens) {
			if (a.isVisible()) {
				g.drawImage(a.getImage(), a.getX(), a.getY(), this);
			}
		}

		// Notification string
		g.setColor(Color.WHITE);
		g.drawString("Aliens left: " + aliens.size(), 5, 15);
	}

	private void drawGameOver(Graphics g) {

		// Draw string GAME OVER
		String msg = "Game Over";
		Font small = new Font("Helcetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2, B_HEIGHT / 2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// check if game is stoped
		inGame();

		// update sprites
		updateCraft();
		updateMissiles();
		updateAliens();

		checkCollisions();

		repaint();
	}

	private void inGame() {
		if (!ingame) {
			timer.stop();
		}
	}

	private void updateCraft() {

		if (craft.isVisible()) {
			craft.move(B_WIDTH, B_HEIGHT);
		}
	}

	private void updateMissiles() {

		ArrayList<Projectile> ms = craft.getMissiles();
		for (int i = 0; i < ms.size(); i++) {
			Projectile m = ms.get(i);
			if (m.isVisible()) {
			//	m.moveHorizontally();
				m.moveVertically();
			} else {
				ms.remove(i);
			}
		}
	}

	private void updateAliens() {
		
		if(aliens.isEmpty()){
			
			ingame = false;
			return;
		}
		
		for(int i = 0; i < aliens.size(); i++){
			
			Asteroid a = aliens.get(i);
			if(a.isVisible()){
				a.move();
			} else {
				aliens.remove(i);
			}
		}
		
		ArrayList<Projectile> ms = craft.getMissiles();
		
		for(Projectile m : ms){
			
			Rectangle r1 = m.getBounds();
			
			for(Asteroid alien : aliens){
				
				Rectangle r2 = alien.getBounds();
				
				if(r1.intersects(r2)){
					m.setVisible(false);
					alien.setVisible(false);
				}
			}
		}
	}

	public void checkCollisions() {

		// r3 - SpaceShip r2 - Aliens r1 - Missiles
		
		Rectangle r3 = craft.getBounds();

		for (Asteroid alien : aliens) {
			Rectangle r2 = alien.getBounds();

			if (r3.intersects(r2)) {
				craft.setVisible(false);
				alien.setVisible(false);
				ingame = false;
			}
		}

		ArrayList<Projectile> ms = craft.getMissiles();

		for (Projectile m : ms) {
			Rectangle r1 = m.getBounds();

			for (Asteroid alien : aliens) {
				Rectangle r2 = alien.getBounds();
				if (r1.intersects(r2)) {
					m.setVisible(false);
					alien.setVisible(false);
				}
			}
		}
	}

	// key listening
	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			craft.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			craft.keyPressed(e);
		}
	}
}
