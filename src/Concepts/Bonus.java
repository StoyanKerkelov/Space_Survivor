package Concepts;

public class Bonus {
	
	private boolean onScreen = false;
	
	// Creates floating objects with different bonuses(enum theBonus) to the spaceShip
	Bonus(){
		
	}
	
	/**
	 * Bonuses move in single direction – vertically (y++) and with constant speed
	 */
	private void move(){
		
	}
	
	
	//They glow or have a specific beacon effect
	private void glowEffect(){
		//Not sure if here or in animator 
	}
	
	
	/**
	 When hitting the Astroids and EnemyShips, nothing happens
	 When hitting the SpaceShip boolean onScreen = false; SpaceShip gets theBonus, may make sounds
	 */
	private void checkCollision(){
		
	}
	
	
	/**
	 * When they move over the GameBoard border: onScreen = false
	 */
	private void flyAway(Bonus bonus){
		
		//if() check...{
		bonus.onScreen = false;
	}
	
}
