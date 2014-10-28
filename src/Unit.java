/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *  Represents all the units (characters) in the game.
 *  (These include player, villagers and monsters)
 *	All variables and methods common to all units are defined here
 */
public abstract class Unit extends GameObject{

	//Instance variables of this class
	private int HP, maxHP, damage, cooldown, cooldownTimer=0;
	private float speed = 0;
	private int die = 0;
	
	//Getters and setters for the instance variables
	
	/**
	 * Get the Unit's HP
	 * @return Unit's HP (an integer)
	 */
	protected int getHP() {
		return HP;
	}
	/**
	 * Set the Unit's HP 
	 * @param hP Unit's HP (an integer)
	 */
	protected void setHP(int hP) {
		HP = hP;
	}
	/**
	 * Get the Unit's MaxHP
	 * @return Unit's MaxHP (an integer)
	 */
	protected int getMaxHP() {
		return maxHP;
	}
	/**
	 * Set the Unit's MaxHP
	 * @param maxHP Unit's MaxHP (an integer)
	 */
	protected void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	/**
	 * Get the Unit's Damage
	 * @return Unit's Damage (an integer)
	 */
	protected int getDamage() {
		return damage;
	}
	/**
	 * Set the Unit's damage 
	 * @param damage Unit's damage (an integer)
	 */
	protected void setDamage(int damage) {
		this.damage = damage;
	}
	/**
	 * Get the Unit's Cooldown
	 * @return Unit's Cooldown (an integer)
	 */
	protected int getCooldown() {
		return cooldown;
	}
	/**
	 * Set the Unit's cooldown 
	 * @param cooldown Unit's cooldown (an integer)
	 */
	protected void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	/**
	 * Get the Unit's Cooldown timer
	 * @return Unit's Cooldown timer (an integer)
	 */
	protected int getCooldownTimer() {
		return cooldownTimer;
	}
	/**
	 * Set the Unit's cooldown timer  
	 * @param cooldownTimer Unit's cooldown timer (an integer)
	 */
	protected void setCooldownTimer(int cooldownTimer) {
		this.cooldownTimer = cooldownTimer;
	}
	/**
	 * Get value of the Unit's Die variable
	 * @return Unit's Die variable (an integer - 0 or 1)
	 */
	protected int getDie() {
		return die;
	}
	/**
	 * Set the Unit's die variable 
	 * @param die Unit's die variable (an integer - 0 or 1)
	 */
	protected void setDie(int die) {
		this.die = die;
	}
	/**
	 * Get the Unit's speed
	 * @return Unit's speed (an integer)
	 */
	public float getSpeed() {
		return speed;
	}
	/**
	 * Set the Unit's speed 
	 * @param speed Unit's speed (an integer)
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	} 
	
	/**
	 * Create a new Unit object
	 * @param xCoord x coordinate of the unit on the map
	 * @param yCoord y coordinate of the unit on the map
	 */
	public Unit(double xCoord, double yCoord){
		super(xCoord, yCoord);
	}

   
    /**
     * Update the unit (world.update() calls this)
     */
    public void update()
    throws SlickException{
    	if(HP < 0){
    		HP = 0;
    	}
    }
	
    /**
     * Fix coordinates based on blocked terrain and/or bounds.
     * Temporary coordinates are fixed and then assigned to the x and y 
     * coordinates of the unit.
     * @param newXcoord Temporary x coordinate to fix
     * @param newYcoord Temporary y coordinate to fix
     * @param world The world object
     * @throws SlickException
     */
   public void fixCoordinates(double newXcoord, double newYcoord, World world)
   throws SlickException{
		if(world.terrainBlock(newXcoord, newYcoord)){
			
			// Check whether the new X coordinate or the new Y coordinate
			// or both are on a blocked tile and change them
			// back to the original coordinate(s).
			
			if (!world.terrainBlock(newXcoord, this.getyCoord())){
				newYcoord = this.getyCoord();
			}else if (!world.terrainBlock(this.getxCoord(), newYcoord)){
				newXcoord = this.getxCoord();
			}else{
				newXcoord = this.getxCoord();
				newYcoord = this.getyCoord();
			}
		}
		
		// Check if the new coordinates are out of bounds and change them 
		//  back to their max/min value.
		
		if(newXcoord < RPG.MIN_X_PIXEL){
			newXcoord = RPG.MIN_X_PIXEL;
		}else if(newXcoord > RPG.MAX_X_PIXEL){
			newXcoord = RPG.MAX_X_PIXEL;
		}
		
		if(newYcoord < RPG.MIN_X_PIXEL){
			newYcoord = RPG.MIN_Y_PIXEL;
		}
		else if(newYcoord > RPG.MAX_Y_PIXEL){
			newYcoord = RPG.MAX_Y_PIXEL;
		}
		
		this.setxCoord(newXcoord);
		this.setyCoord(newYcoord);
   }
	
	
	/**
	 * Get damage done to itself
	 * @param damage Damage caused by the player attacking the monster
	 */
	public void damage(int damage)
	throws SlickException{
		this.setHP(this.getHP() - damage);
	}
	
	/**
	 * Die if HP is 0
	 */
	public void death()
	throws SlickException{
		if(this.getHP() < 0){
			this.setHP(0);
			this.setDie(1);
		}
	}
   
    /**
     * {@inheritDoc}
     */
	@Override
    public void render(Graphics g)
    throws SlickException{
    	super.render(g);
    	drawHealthBar(g); 	
    }
    
	/**
	 * Draw a health bar above the head of a unit
	 * @param g The Slick graphics object, used for drawing.
	 */
    public void drawHealthBar(Graphics g)
    throws SlickException{
    	// Panel colours
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp
    	
    	 // Variables for layout
        String text;                			// Text to display
        int text_x, text_y;         			// Coordinates to draw text
        int bar_x, bar_y;           			// Coordinates to draw rectangles
        int bar_width = 90, bar_height = 30;  	// Size of rectangle to draw
        int hp_bar_width;           			// Size of red (HP) rectangle
        float health_percent;       			// Unit's health, as a percentage
        
        bar_x = (int)this.getxCoord() - bar_width/2;
        bar_y = (int)this.getyCoord() - bar_height/2 - RPG.PANELHEIGHT + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        
        health_percent = ((float)HP/maxHP);      
        hp_bar_width = (int) (bar_width * health_percent);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        
        text = this.getClass().getName();
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        text_y = (int)this.getyCoord() - bar_height/2 - RPG.PANELHEIGHT + 25;
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
    }


    
}