package sprites;

public class Asteroid extends Sprite{

	private final int INITIAL_X = 250;
	private final int imageWidth = 16;
	private final int imageHeight = 16;
	
	public Asteroid(int x, int y){
		
		super(x,y);
		
		initAlien();
	}

	private void initAlien() {
		
		loadImage("src/res/Astroid32x32.png", imageWidth, imageHeight);
		
		
		//we need image dimensions for collision detection
		getImageDimensions();
	}
	
	public void move(){
		
		if(x < 0){
			x = INITIAL_X;
		}
		
		//x -= 1;
		y += 1;
	}
	
}
