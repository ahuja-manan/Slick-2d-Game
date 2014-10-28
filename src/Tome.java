/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the Tome in the game
 */
public class Tome extends Item{
	private final String PATH = "assets/items/book.png";
	
	/**
	 * Create a new Tome object
	 * @param xCoord x coordinate of the Tome on the map
	 * @param yCoord y coordinate of the Tome on the map
	 * @throws SlickException
	 */
	public Tome(double xCoord, double yCoord)
	throws SlickException{
		super(xCoord, yCoord);
		this.setImg(new Image(PATH));
		this.setEffectOncooldown(-800);
	}

}
