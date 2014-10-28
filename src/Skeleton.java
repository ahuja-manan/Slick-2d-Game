/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents all the skeletons in the game
 */
public class Skeleton extends AggressiveMonster{
	
	private static final String PATH = "assets/units/skeleton.png";
	
	/**
	 * Create a new Skeleton object
	 * @param xCoord x coordinate of the skeleton	
	 * @param yCoord y coordinate of the skeleton
	 * @throws SlickException
	 */
    public Skeleton(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image(PATH));
    	this.setMaxHP(100);
    	this.setHP(getMaxHP());
    	this.setDamage(16);
    	this.setCooldown(500);
    }

}
