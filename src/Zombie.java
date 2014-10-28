/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents all the zombies in the game
 */

public class Zombie extends AggressiveMonster{
	private static final String PATH = "assets/units/zombie.png";
	
	/**
	 * Create a new Zombie object
	 * @param xCoord x coordinate of the Zombie
	 * @param yCoord y coordinate of the Zombie
	 * @throws SlickException
	 */
    public Zombie(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image(PATH));
    	this.setMaxHP(60);
    	this.setHP(getMaxHP());
    	this.setDamage(10);
    	this.setCooldown(800);
    }

}
