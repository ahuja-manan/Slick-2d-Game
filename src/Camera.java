/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.SlickException;


/** Represents the camera that controls our viewpoint.
 */
public class Camera
{

    /** The unit this camera is following */
    private Player unitFollow;
    
    /** The width and height of the screen */
    /** Screen width, in pixels. */
    public final int screenwidth;
    /** Screen height, in pixels. */
    public final int screenheight;

    
    /** The camera's position in the world, in x and y coordinates. */
    private int xPos;
    private int yPos;

    /** 
     * Get x position of camera
     * @return x position
     */
    public int getxPos() {
        return xPos;
    }
    /**
     * Get y position of camera
     * @return	y position
     */
    public int getyPos() {
        return yPos;
    }

    
    /**
     * Create a new camera object
     * @param player the player around which the camera is centered
     * @param screenwidth	width of the screen in pixels
     * @param screenheight	height of the screen in pixels
     * @throws SlickException
     */
    public Camera(Player player, int screenwidth, int screenheight)
    		throws SlickException
    		
    {       	
    	this.screenheight = screenheight;
    	this.screenwidth = screenwidth;
    	/** X and Y coordinates of the camera class will be at the top left corner of the screen
    	 * while the player is at the centre. */
    	xPos = (int)player.getxCoord() - screenwidth/2;
    	yPos = (int)player.getyCoord() - screenheight/2;
    }

    /** Update the game camera to recentre it's viewpoint around the player 
     */
    public void update()
    throws SlickException
    {
		xPos = (int)unitFollow.getxCoord() - screenwidth/2;
		
		/** The camera stops on reaching the X and Y coordinate bounds. */
		if(xPos > getMaxX()){
			xPos = getMaxX();
		}else if(xPos < getMinX()){
			xPos = getMinX();
		}
		
		yPos = (int)unitFollow.getyCoord() - screenheight/2;
		
		if(yPos > getMaxY()){
			yPos = getMaxY();
		}else if(yPos < getMinY()){
			yPos = getMinY();
		}
    }
    
    /** Returns the minimum x value on screen 
     */
    public int getMinX(){
    	return (int)RPG.MIN_X_PIXEL;
    }
    
    /** Returns the maximum x value on screen 
     */
    public int getMaxX(){
    	return (int)RPG.MAX_X_PIXEL - screenwidth;
    }
    
    /** Returns the minimum y value on screen 
     */
    public int getMinY(){
        return (int)RPG.MIN_Y_PIXEL;
    }
    
    /** Returns the maximum y value on screen 
     */
    public int getMaxY(){
        return (int)RPG.MAX_Y_PIXEL - screenheight;
    }
    
    
    /** Tells the camera to follow a given unit. 
     */
    public void followUnit(Object unit)
    throws SlickException
    {	/** If the object unit belongs to the class Player, then
    		the player unitFollow becomes equal to unit */
    	if(unit.getClass() == Player.class){
        	unitFollow = (Player) unit;
        	}
    }
    
}