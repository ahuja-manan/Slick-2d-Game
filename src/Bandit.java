/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents all the bandits in the game
 */

public class Bandit extends AggressiveMonster{
	
	private static final String PATH = "assets/units/bandit.png";
	
	/**
	 * Create a new Bandit object 
	 * @param xCoord x coordinate of the bandit
	 * @param yCoord y coordinate of the bandit
	 * @throws SlickException
	 */
    public Bandit(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image(PATH));
    	this.setMaxHP(40);
    	this.setHP(getMaxHP());
    	this.setDamage(8);
    	this.setCooldown(200);
    }

}
