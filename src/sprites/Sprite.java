package sprites;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Sprite {

	protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;
	
   
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        vis = true;
    }

    //using the size of the ImageIcon
	protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
	
	//using pre-set size of Imageicon
	protected void loadImage(String imageName, int setWidth, int setHeight) {

		loadImage(imageName);
		
		BufferedImage resizedImg = new BufferedImage(setWidth, setHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = resizedImg.createGraphics();
		
		((Graphics2D) g2).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, setWidth, setHeight, null);
		g2.dispose();
		 
		image =  resizedImg;
		
    }
    
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }  
    
    public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Image getImage() {
        return image;
    }
    
    public int getX() { 
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }
    
    //for collision detection
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
