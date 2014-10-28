/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import java.util.Vector;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the villager Elvira
 */
public class Elvira extends Villager{
	//The possible dialogues for Elvira
	private static final String FULL_HEALTH = "Return to me if you ever need healing.";	
	private static final String NOT_FULL_HEALTH = "You're looking much healthier now.";
	

	/**
	 * Create a new Elvira object
	 * @param xCoord x coordinate of Elvira on the map
	 * @param yCoord y coorinate of Elvira on the map
	 * @throws SlickException
	 */
    public Elvira(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image("assets/units/shaman.png"));
    }
    

    @Override
    public void interact(Player player, Vector <Item> inventory)
    throws SlickException{
    	//If player wasn't on full health, set HP to maxHP
    	if(player.getHP() != player.getMaxHP()){
    		player.setHP(player.getMaxHP());
    	}
    }
    

    @Override
    public void talk(Player player, Vector <Item> inventory)
    throws SlickException{
    	//Set CurrentDialogue depending on whether the player was on
    	//full health or not.
    	if(player.getHP() == player.getMaxHP()){
    		this.setCurrentDialogue(FULL_HEALTH);
    	}else{
    		this.setCurrentDialogue(NOT_FULL_HEALTH);
    	}
    	
    }

}
