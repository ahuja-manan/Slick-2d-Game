/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import java.util.Vector;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the villager Garth
 */
public class Garth extends Villager{
	//The possible dialogues for Garth
	private static final String NO_AMULET = "Find the Amulet of Vitality, across the river to the west.";
	private static final String NO_SWORD = "Find the Sword of Strength - cross the river and back, on the east side.";
	private static final String NO_TOME = "Find the Tome of Agility, in the Land of Shadows.";
	private static final String ALL_TREASURE = "You have found all the treasure I know of.";
	
	private static final String PATH = "assets/units/peasant.png";
	
	/**
	 * Create a new Garth object
	 * @param xCoord x coordinate of Garth on the map
	 * @param yCoord y coordinate of Garth on the map
	 * @throws SlickException
	 */
    public Garth(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image(PATH));
    }
    

    @Override
    public void talk(Player player, Vector <Item> inventory)
    throws SlickException{
    		
    	//Set CurrentDialogue depending on what item player does/doesn't have.

    		if(!itemIn(Amulet.class, inventory)){
    			this.setCurrentDialogue(NO_AMULET);
    		}else if(!itemIn(Sword.class, inventory)){
    			this.setCurrentDialogue(NO_SWORD);
    		}else if(!itemIn(Tome.class, inventory)){
    			this.setCurrentDialogue(NO_TOME);
    		}else{
    			this.setCurrentDialogue(ALL_TREASURE);
    		}
    		
    	}
	
}

    
  

