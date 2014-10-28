/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the Draelic in the game
 */

public class Draelic extends AggressiveMonster{
	private static final String PATH = "assets/units/necromancer.png";
	
	/**
	 * Creates a Draelic object 
	 * @param xCoord x coordinate of the Draelic
	 * @param yCoord y coordinate of the Draelic
	 * @throws SlickException
	 */
    public Draelic(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image(PATH));
    	this.setMaxHP(140);
    	this.setHP(getMaxHP());
    	this.setDamage(30);
    	this.setCooldown(400);
    }

}
