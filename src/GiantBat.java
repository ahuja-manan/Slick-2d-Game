/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents all the bats in the game
 */

public class GiantBat extends PassiveMonster{
	private static final String PATH = "assets/units/dreadbat.png";
	
	/**
	 * Create a new GiantBat object 
	 * @param xCoord x coordinate of the player
	 * @param yCoord y coordinate of the player 
	 * @throws SlickException
	 */
    public GiantBat(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image(PATH));
    	this.setMaxHP(40);
    	this.setHP(getMaxHP());
    	this.setDamage(0);
    	this.setCooldown(0);
    }
  

}
