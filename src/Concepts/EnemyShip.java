package Concepts;


public class EnemyShip {
		
//	private Texture texture; 
	private int speed;
//	private Direction direction;
	private int hitpoints;
	private int damage;
	boolean isAlive = false;
	boolean onScreen = false;	// do we need two booleans?
	
/**
3
4. They get shot and have boolean isAlive  if(!isAlive){ onScreen = false}
5. 

 */
	/*Create enemyShips of different types constructor()may implement factory method
	EnemyShip( Texture texture,int speed, Direction direction, int hitpoints, int damage){
		this.texture = texture;
		this.speed = speed;
		this.direction = direction;
		this.hitpoints = hitpoints;
		this.damage = damage;
		this.isAlive = true;
	}
	*/
	/**
	 * movement with X, Y direction and speed;
	 */
	private void move(){
		
	}
	
	
	/**
	 *  shoot() method → shooting speed , projectile constructor;
	 */
	private void shoot(){
		
	}
	
	
	/**
	 * check  projectiles, astroids, crashes
	 */
	private void checkCollision(){
		
	}
	
	
	/**
	 * When instance of EnemyShip leave playground margins onScreen = false;// removed from animator
	 */
	private void flyAway(){
		
	}
	
}
