package Concepts;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class GameBoard {

	private int gBWidth = 480, gBHeight = 800;
	
	//Fallows floating object 
	/*
	 ArrayList <enemyShip> enemyShipsArray = new  ArrayList <enemyShip>();
	 ArrayList <Asteroids> asteroidsArray = new  ArrayList <Asteroids>();
	 ArrayList <Bonuses>  bonusesArray = new  ArrayList <Bonuses>();
	 */
	 
	 // 5. Counts points, lives
	private long playerPoints = 0;
	private int lives =4;
	
	
	//Animates Cosmos background
	public void AnimateBackGround(){
		
	}
	
	
	
	/*
	//registers player input and act acordingly with Animator class
	addKeyListener(new KeyListener() {
		
	}
	*/
	
	//Has Pause method (connected with Clock and Animator classes)
	private void Pause(){
		
	}
	
	/**
	 * G	ameOver() method with congrats, score message and Animator.Pause()
	 */
	/*
	private void GameOver(){
		if(lives == 0){
			 Animator.Pause();
		}
	}
	*/
	
}
