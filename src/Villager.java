/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import java.util.Vector;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Represents all the villagers in the game
 * All variables and methods common to all
 * villagers are defined here.
 */
public abstract class Villager extends Unit{
	
	//Instance variables of this class
	private String currentDialogue = "";
	private int talk_timer = 0;
	private int delta = 0;

	/**
	 * Get the villager's current dialogue
	 * @return current dialogue 
	 */
	protected String getCurrentDialogue() {
		return currentDialogue;
	}
	/**
	 * Set the villager's current dialogue
	 * @param currentDialogue current dialogue
	 */
	protected void setCurrentDialogue(String currentDialogue) {
		this.currentDialogue = currentDialogue;
	} 
	
	/**
	 * Create a new Villager object
	 * @param xCoord x coordinate of the villager on the map
	 * @param yCoord y coordinate of the villager on the map
	 * @throws SlickException
	 */
    public Villager(double xCoord, double yCoord)
    throws SlickException{	
    	super(xCoord, yCoord);
	    this.setHP(1);
	    this.setMaxHP(1);
	    this.setCooldown(0);
	    this.setDamage(0);
    }
   
	/**
	 * Interact with the player and affect the player in a certain way.
	 * @param player 	The player to interact with
	 * @param inventory The inventory of the player to check what items the player
	 *					does/doesn't have as that affects the kind of interaction.
	 * @throws SlickException
	 */
    public void interact(Player player, Vector <Item> inventory)
    throws SlickException{
    	//This method is overridden in the subclasses as different villagers
    	//interact with the player differently.
    }
    
    /**
     * Start talk timer when player is in range and T has been pressed.
     * @param delta Time passed since last frame (milliseconds).
     */
	public void startTimer(int delta) 
	throws SlickException{
		this.delta = delta;
		this.talk_timer = 4000;
	}
    
	/**
	 * Talk to the player.
	 * @param player 	 The player to talk to
	 * @param inventory  The player's inventory
	 * @throws SlickException
	 */
    public void talk(Player player,  Vector <Item> inventory)
    throws SlickException{
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void render(Graphics g)
    throws SlickException{
    	this.getImg().drawCentered((int)this.getxCoord(),(int)this.getyCoord());
    	drawHealthBar(g); 
    	if(talk_timer > 0){
    		renderDialogue(g);
    		talk_timer -= delta;
    	}
    	}
    /**
     * Render the current dialogue of the villager on the screen.
     * @param g The Slick graphics object, used for drawing.
     */
    public void renderDialogue(Graphics g)
    throws SlickException{
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        
        int text_x, text_y, bar_x, bar_y;
        int bar_width = g.getFont().getWidth(this.currentDialogue) , bar_height = 30;

        text_x = (int)this.getxCoord() - bar_width/2;
        text_y = (int)this.getyCoord() - bar_height/2 - RPG.PANELHEIGHT + 25 - bar_height;
  

        bar_x = (int)this.getxCoord() - bar_width/2;
        bar_y = (int)this.getyCoord() - bar_height/2 - RPG.PANELHEIGHT + 20 - bar_height;
        if(talk_timer > 0){
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        
        text_x = bar_x + (bar_width - g.getFont().getWidth(this.currentDialogue)) / 2;
        g.setColor(VALUE);
        g.drawString(this.currentDialogue, text_x, text_y);
        }
    	
    }
    
    /**
     * Check if the player's inventory has an item that belongs to a certain class
     * @param c  Any class
     * @param 	 inventory The player's inventory
     * @return 	 true if an item belonging to that class was found in the inventory and false otherwise.
     * @throws SlickException
     */
	public boolean itemIn(Class<?> c, Vector <Item> inventory)
	throws SlickException{
		for(int i=0; i<inventory.size(); i++){
			if(inventory.elementAt(i).getClass().equals(c)){
				return true;
			}
		}return false;
	}
	
	@Override
	public void damage(int damage)
	throws SlickException{
		//Overrides Unit.damage to make villager invincible
	}
	
	@Override
	public void death()
	throws SlickException{
		//Overrides Unit.death to make villager invincible
	}
}