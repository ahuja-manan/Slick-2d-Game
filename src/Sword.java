/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the Sword in the game
 */
public class Sword extends Item{
	
	private final String PATH = "assets/items/sword.png";
	
	/**
	 * Create a new Sword object
	 * @param xCoord x coordinate of the Sword on the map
	 * @param yCoord y coordinate of the Sword on the map
	 * @throws SlickException
	 */
	public Sword(double xCoord, double yCoord)
	throws SlickException{
		super(xCoord, yCoord);
		this.setImg(new Image(PATH));
		this.setEffectOndamage(30);
	}

}
