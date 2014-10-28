/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.SlickException;

/**
 * Represents all the passive monsters in the game
 */
public abstract class PassiveMonster extends Monster{
	private final float SPEED = 0.2f;
	//Timers to change direction and run away
	private int dir_timer = 0;
	private int run_timer = 0;
	//Variables that determine what random direction the monster moves in
	private int dir_x = 0;
	private int dir_y = 0;
	
	/**
	 * Create a new PassiveMonster object
	 * @param xCoord x coordinate of the monster
	 * @param yCoord y coordinate of the monster
	 * @throws SlickException
	 */
    public PassiveMonster(double xCoord, double yCoord)
    throws SlickException{	
    	super(xCoord, yCoord);
    	this.setSpeed(SPEED);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(World world, Player player, int delta)
    throws SlickException{
    	//Update direction timer 
    	dir_timer += delta; 
    	//Generate random directions if the direction timer is 3000 (or slightly higher)
    	if(dir_timer >= 3000){
    		dir_x = (int)(Math.random()*3)-1;
    		dir_y = (int)(Math.random()*3)-1;
    		dir_timer = 0;
    	}
    	
		double changeInXcoord = dir_x * delta * this.getSpeed();
		double changeInYcoord = dir_y * delta * this.getSpeed();
		
		double newXcoord = this.getxCoord() + changeInXcoord;
		double newYcoord = this.getyCoord() + changeInYcoord;
		

		//Run away from player if run timer is positive
		if(run_timer > 0){
	    		double distTotal = this.calcDistance(player);
	    		double xToMove = (this.getxCoord() - player.getxCoord()) * delta * SPEED/distTotal; 
	    		double yToMove = (this.getyCoord() - player.getyCoord()) * delta * SPEED/distTotal;
	    		newXcoord += xToMove;
	    		newYcoord += yToMove; 
	    		//Update run timer
	    		run_timer -= delta;
		}					
		
		fixCoordinates(newXcoord, newYcoord, world);
		
    }
    
    /**
     * {@inheritDoc}
     */
    @Override 
	public void damage(int damage){
		this.setHP(this.getHP() - damage);
		//Set run timer to 5000 if attacked by a player
		run_timer = 5000;
		
	}
}
