/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import java.util.Random;
import org.newdawn.slick.SlickException;

/**
 * Represents all the aggressive monsters in the class
 */
public abstract class AggressiveMonster extends Monster{
	//The fixed speed of an aggressive monster
	private final float SPEED = 0.25f;
	
	/**
	 * Create a new AggressiveMonster object
	 * @param xCoord x coordinate of the monster
	 * @param yCoord y coordinate of the monster
	 * @throws SlickException
	 */
    public AggressiveMonster(double xCoord, double yCoord)
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
    	double distTotal = this.calcDistance(player);
    	//If player is within 50 to 150 pixels, then move towards it.
    	if (distTotal <= 150 && distTotal > 50){
    		double xToMove = (this.getxCoord() - player.getxCoord()) * delta * this.getSpeed()/distTotal; 
    		double yToMove = (this.getyCoord() - player.getyCoord()) * delta * this.getSpeed()/distTotal;
    		
    		double newXcoord = (this.getxCoord() - xToMove);
    		double newYcoord = (this.getyCoord() - yToMove);
    		//Prevent monster from going out of bounds and/or on blocked terrain 
    		fixCoordinates(newXcoord, newYcoord, world);
    	}	
    	
    	//Attack player if it is within 50 pixels.
    	else if(distTotal <= 50){
    		attack(player);
    	}
    	//Update cooldown timer
		if(this.getCooldownTimer() > 0){
			this.setCooldownTimer(this.getCooldownTimer() - delta);
		}    		
    }
    
    /**
     * Attack the player
     * @param player The player to attack
     * @throws SlickException
     */
    public void attack (Player player)
    throws SlickException{
    		//Attack only if Cooldown Timer is 0
    		if(this.getCooldownTimer() <= 0){
    			
    			//Generate a random damage
    			Random randomGenerator = new Random();
    			int randomDamage = randomGenerator.nextInt((this.getDamage()) + 1);
    			
    			//Damage player
    			player.damage(randomDamage);
    			
    			//Set Cooldown Timer to max Cooldown after an attack
    			this.setCooldownTimer(this.getCooldown());
    			}
    			player.death();
    			player.respawn();
    			}
    }