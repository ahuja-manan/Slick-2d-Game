/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import org.newdawn.slick.SlickException;

/**
 * Represents all the items in the game
 */
public abstract class Item extends GameObject{
	//Instance variables of the class
	private int effectOnHP = 0, effectOnMaxHP = 0, effectOndamage = 0, effectOncooldown = 0;
	
	//Getters/Setters
	/**
	 * Get this item's effect on HP
	 * @return effect on HP (an integer)
	 */
	public int getEffectOnHP() {
		return effectOnHP;
	}
	/**
	 * Set this item's effect on HP
	 * @param effect on HP (an integer)
	 */
	public void setEffectOnHP(int effectOnHP) {
		this.effectOnHP = effectOnHP;
	}
	/**
	 * Get this item's effect on MaxHP
	 * @return effect on MaxHP (an integer)
	 */
	public int getEffectOnMaxHP() {
		return effectOnMaxHP;
	}
	
	/**
	 * Set this item's effect on MaxHP
	 * @param effectOnMaxHP effect on MaxHP (an integer)
	 */
	public void setEffectOnMaxHP(int effectOnMaxHP) {
		this.effectOnMaxHP = effectOnMaxHP;
	}
	/**
	 * Get this item's effect on damage
	 * @return effect on damage (an integer)
	 */
	public int getEffectOndamage() {
		return effectOndamage;
	}
	
	/**
	 * Set this item's effect on damage
	 * @param effectOndamage effect on damage (an integer)
	 */
	public void setEffectOndamage(int effectOndamage) {
		this.effectOndamage = effectOndamage;
	}
	
	/**
	 * Get this item's effect on cooldown
	 * @return  effect on cooldown (an integer)
	 */
	public int getEffectOncooldown() {
		return effectOncooldown;
	}
	/**
	 * Set this item's effect on cooldown
	 * @param effectOncooldown effect on cooldown (an integer)
	 */
	public void setEffectOncooldown(int effectOncooldown) {
		this.effectOncooldown = effectOncooldown;
	}

	
	/**
	 * Create a new Item object
	 * @param xCoord x coordinate of the item on the map
	 * @param yCoord y coordinate of the item on the map
	 * @throws SlickException
	 */
	public Item(double xCoord, double yCoord)
	throws SlickException{
		super(xCoord, yCoord);
	}

	/**
	 * Interact with the player and affect it in a certain way
	 * @param player The player to affect
	 */
    protected void interact(Player player){
    	player.setMaxHP(player.getMaxHP() + this.getEffectOnMaxHP());
    	player.setHP(player.getHP() + this.getEffectOnHP());
    	player.setCooldown(player.getCooldown() + this.getEffectOncooldown());
    	player.setDamage(player.getDamage() + this.getEffectOndamage());
    }
	

}

