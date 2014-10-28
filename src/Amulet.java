/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the Amulet in the game
 */
public class Amulet extends Item{
	
	private final String PATH = "assets/items/amulet.png";
	
	/**
	 * Create a new Amulet object
	 * @param xCoord x coordinate of the Amulet on the map
	 * @param yCoord y coordinate of the Amulet on the map
	 * @throws SlickException
	 */
	public Amulet(double xCoord, double yCoord)
	throws SlickException{
		super(xCoord, yCoord);
		this.setImg(new Image(PATH));
		this.setEffectOnHP(80);
		this.setEffectOnMaxHP(80);
	}

}
