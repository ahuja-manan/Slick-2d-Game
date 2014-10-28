/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
/**
 * Represents all the objects in the game.
 * (this includes player, villagers, monsters and items)
 */

public abstract class GameObject {
	
	//Defining instance variables of this class
	private double xCoord, yCoord;
	private Image img;
	
	//Getter/setters for the instance variables
	protected double getxCoord() {
		return xCoord;
	}
	protected void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}
	protected double getyCoord() {
		return yCoord;
	}
	protected void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}
	protected Image getImg() {
		return img;
	}
	protected void setImg(Image img) {
		this.img = img;
	}
	
	/**
	 * Create a new GameObject object
	 * @param xCoord x coordinate of the GameObject on the map
	 * @param yCoord y coordinate of the GameObject on the map
	 */
	public GameObject(double xCoord, double yCoord){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	/**
	 * Render the GameObject object on the screen
	 * @param g The Slick graphics object, used for drawing.
	 * @throws SlickException
	 */
	public void render(Graphics g)
	throws SlickException{
		img.drawCentered((int)xCoord,(int)yCoord);
	}
	
	/**
	 * Calculate distance from another GameObject object
	 * @param object The game object to calculate distance from
	 * @return
	 */
    protected double calcDistance(GameObject object){
    	double distX = Math.abs(object.getxCoord() - this.getxCoord());
    	double distY = Math.abs(object.getyCoord() - this.getyCoord());
    	double distTotal = Math.sqrt(distX * distX + distY * distY);
    	return distTotal;
    }
}
