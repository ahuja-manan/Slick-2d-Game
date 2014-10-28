/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.SlickException;

/**
 * Represents all the monsters (passive & aggressive) in the game.
 */
public abstract class Monster extends Unit{
	
	/**
	 * Create a new Monster object
	 * @param xCoord x coordinate of the monster on the map
	 * @param yCoord y coordinate of the monster on the map
	 * @throws SlickException
	 */
    public Monster(double xCoord, double yCoord)
    throws SlickException{	
    	super(xCoord, yCoord);
    }
	
    /**
     * Update the monster
     * @param world	 The World object
     * @param player The player depending on whose actions, the monster is updated
     * @param delta  Time passed since last frame (milliseconds).
     * @throws SlickException
     */
	public void update(World world, Player player, int delta)
	throws SlickException{
		//It's empty since the subclasses implement this method differently
	}
    

	

		
	}

	
	
