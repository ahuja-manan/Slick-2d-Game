/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import java.util.Vector;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the villager Prince
 */
public class Prince extends Villager{
	//The possible dialogues for Prince
	private static final String NO_ELIXIR = "Please seek out the Elixir of Life to cure the king.";
	private static final String ELIXIR = "The elixir! My father is cured! Thankyou!";
	
	private static final String PATH = "assets/units/prince.png";
	
	/**
	 * Create a new Prince object
	 * @param xCoord x coordinate of Prince on the map
	 * @param yCoord y coordinate of the Prince on the map
	 * @throws SlickException
	 */
    public Prince(double xCoord, double yCoord)
    throws SlickException{
    	super(xCoord, yCoord);
    	this.setImg(new Image(PATH));
    }
   
    @Override
    public void interact(Player player, Vector <Item> inventory)
    throws SlickException{
    	//If player had Elixir, then remove it from the inventory.
    	for(int i=0; i<inventory.size(); i++){
    		if(inventory.elementAt(i).getClass() == Elixir.class){
    			inventory.removeElementAt(i);
    			player.win = 1;
    		}
    	}	
    }
    
    @Override
    public void talk(Player player, Vector <Item> inventory)
    throws SlickException{
    	//Set CurrentDialogue depending on whether the player had the
    	//Elixir or not.
    		if(!itemIn(Elixir.class, inventory)){
    			this.setCurrentDialogue(NO_ELIXIR);
    		}else{
    			this.setCurrentDialogue(ELIXIR);
    			}
    		}
    		
  

}
