/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents the Elixir in the game
 */
public class Elixir extends Item{
	
	private final String PATH = "assets/items/elixir.png";
	
	/**
	 * Create a new Elixir object
	 * @param xCoord x coordinate of the Elixir on the map
	 * @param yCoord y coordinate of the Elixir on the map
	 * @throws SlickException
	 */
	public Elixir(double xCoord, double yCoord)
	throws SlickException{
		super(xCoord, yCoord);
		this.setImg(new Image(PATH));
	}

}
