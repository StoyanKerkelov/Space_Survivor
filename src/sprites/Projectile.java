package sprites;

public class Projectile extends Sprite {

	private final int BOARD_WIDTH = 1024;
	private final int BOARD_HEIGHT = 768;
	private final int MISSILE_SPEED = 2;

	public Projectile(int x, int y) {
		
		super(x, y);
		
		initMissile();
	}

	private void initMissile() {

		loadImage("src/res/laserBlue07.png", 8, 32);
		getImageDimensions();
	}

	public void moveVertically() {

		y -= MISSILE_SPEED;

		/**
		 * The missile moves at constant speed. When it hits the 
		 * right border of the Board, it becomes invisible. It is
		 * then removed from the list of missiles. 
		 */
		if (y < 0) {
			vis = false;
		}
	}
	
	public void moveHorizontally() {

		x += MISSILE_SPEED;

		/**
		 * The missile moves at constant speed. When it hits the 
		 * right border of the Board, it becomes invisible. It is
		 * then removed from the list of missiles. 
		 */
		if (x > BOARD_WIDTH) {
			vis = false;
		}
	}
	
	
}
