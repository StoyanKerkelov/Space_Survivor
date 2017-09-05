package sprites;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/*Sprite - denote an image or an animation in a scene.
Here movable object or its Java class.*/

public class SpaceShip extends Sprite{

	private int dx;
    private int dy;
    private ArrayList<Projectile> missiles;
	
    
    public SpaceShip(int x, int y) {
        
    	super(x, y);
    	
        initCraft();
    }
    
    private void initCraft() {
        
    	missiles = new ArrayList<>();
    	loadImage("src/res/Boeing.png", 64, 64);
        getImageDimensions();
    }
    
    //repaint craft.png on the move
 //   public void move(int constraintX, int constraintY) {
    public void move(int constraintX, int constraintY) {
    	x += dx;
		y += dy;
		
		if (x < - 32) {
		    x = - 32;
		}
		
		if(x > constraintX - 32){
			x = constraintX - 32;
		}
		
		if (y < - 32) {
		    y = - 32;
		}
		
		if(y > constraintY - 32){
			y = constraintY - 32;
		}
    }
    
    public void keyPressed(KeyEvent e) {
 
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fireVertically();
//          fireHorizontally();
        }
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    //on release stop moving
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    public void fireHorizontally() {
        missiles.add(new Projectile(x + width, y + height / 2));
    }
    
    public void fireVertically() {
        missiles.add(new Projectile(x + width / 2 - (4), y - height));
    }
    
    public ArrayList<Projectile> getMissiles(){
    	return missiles;
    }
    
}
