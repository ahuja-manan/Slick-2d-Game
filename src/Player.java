/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import java.util.Random;
import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Unit{
	//Defining static variables for all the stats
	private static final int MAX_HP = 100;
	private static final int DAMAGE = 26;
	private static final int COOLDOWN = 600;
	private static final float SPEED = 0.25f;
	private static final String PLAYER_IMG_PATH = "assets/units/player.png";
	private static final String PANEL_IMG_PATH = "assets/panel.png";
	public int win = 0;
	private Image panel;
	
	/**
	 * Create a new Player object
	 * @param xCoord x coordinate of the player on the map
	 * @param yCoord y coordinate of the player on the map
	 * @throws SlickException
	 */
	public Player(double xCoord, double yCoord)
	throws SlickException
	{	
		super(xCoord, yCoord);
		this.setImg(new Image(PLAYER_IMG_PATH));
		this.setMaxHP(MAX_HP);
		this.setHP(this.getMaxHP());
		this.setDamage(DAMAGE);
		this.setCooldown(COOLDOWN);
		this.setSpeed(SPEED);
		this.panel = new Image(PANEL_IMG_PATH);
	}

	/**
	 * Get the panel image	
	 * @return Image of panel
	 */
	public Image getPanel() {
		return panel;
	}
		
	/**
	 * Update the player depending on the key presses.
	 * @param world 	The World object
	 * @param dir_x 	Player's movement direction along X.
	 * @param dir_y 	Player's movement direction along Y.
	 * @param attack 	Variable that tells if the attack key('A') was pressed or not.
	 * @param talk		Variable that tells if the talk key('T') was pressed or not.
	 * @param delta		Time passed since last frame (milliseconds).
	 * @param villagers	Vector containing all the villagers in the world.
	 * @param monsters	Vector containing all the monsters in the world.
	 * @param items		Vector containing all the items in the world.
	 * @param inventory	Vector containing all the items in the inventory.
	 * @throws SlickException
	 */
	public void update(World world, double dir_x, double dir_y, double attack, double talk, int delta,  Vector <Villager> villagers, Vector <Monster> monsters, Vector <Item> items, Vector <Item> inventory)
	throws SlickException{
		
		double changeInXcoord = dir_x * delta * this.getSpeed();
		double changeInYcoord = dir_y * delta * this.getSpeed();
		
		double newXcoord = this.getxCoord() + changeInXcoord;
		double newYcoord = this.getyCoord() + changeInYcoord;
		
		/** Check if the new tile blocks movement. */
		fixCoordinates(newXcoord, newYcoord, world);
		
		//Update Cooldown Timer
		if(this.getCooldownTimer() > 0){
			this.setCooldownTimer(this.getCooldownTimer() - delta);
		}
		
		//Iterate through all the villagers and interact with them
		for(int i=0; i<villagers.size();i++){
			//Get affected in a certain way if villager is within 50 pixels
			if (this.calcDistance(villagers.elementAt(i)) <= 50){
				villagers.elementAt(i).interact(this, inventory);
			}
			//Talk if villager is within 50 pixels and talk key is pressed
			if (this.calcDistance(villagers.elementAt(i)) <= 50 && talk == 1){	
				villagers.elementAt(i).startTimer(delta);
				villagers.elementAt(i).talk(this, inventory);
			}
		}
		//Iterate through all the monsters and interact with them	
		for(int i=0;i<monsters.size();i++){
			//Attack monster if it's within 50 pixels and attack key is pressed
			if ((this.calcDistance(monsters.elementAt(i)) <= 50.0) && (attack == 1)){
				attack(monsters.elementAt(i));	
				monsters.elementAt(i).death();
				if(monsters.elementAt(i).getDie() == 1){
					monsters.removeElementAt(i);
				}    
			}
		}
		
		//Iterate through all the items and interact with them
		for(int i=0;i<items.size();i++){
			//Get affected in a certain way if item is within 50 pixels
			if(items.elementAt(i).calcDistance(this) <= 50){
				//Remove item from world and add to inventory when in range
				items.elementAt(i).interact(this);
				inventory.addElement(items.elementAt(i)); 
				items.removeElementAt(i);
			}
		}	
	}

	
/**
 * Attack a monster	
 * @param monster the monster to attack
 * @throws SlickException
 */
public void attack (Monster monster)
throws SlickException{
		//Attack only if Cooldown Timer is 0
		if(this.getCooldownTimer() <= 0){
			Random randomGenerator = new Random();
			int randomDamage = randomGenerator.nextInt((this.getDamage()));
			monster.damage(randomDamage);
			//Set Cooldown Timer to max Cooldown after an attack
			this.setCooldownTimer(this.getCooldown());
			}	
}

/**
 * Respawn after dying
 */
public void respawn(){
	if(this.getDie() == 1){
		this.setxCoord(738);
		this.setyCoord(549);
		this.setHP(100);
	}
}

/**
 * {@inheritDoc}
 */
@Override
public void render(Graphics g)
throws SlickException{
	this.getImg().drawCentered((int)this.getxCoord(),(int)this.getyCoord());
	if(this.win == 1){
		this.win(g);
	}
	}

public void win(Graphics g){
	Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
    Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
    
    int text_x, text_y, bar_x, bar_y;
    int bar_width = 800;
    int bar_height = 600;
    text_x = (int)this.getxCoord() - bar_width/2;
    text_y = (int)this.getyCoord() - bar_height/2 - RPG.PANELHEIGHT + 25 - bar_height;
    String text;

    bar_x = 0;
    bar_y = 0;
    g.setColor(BAR_BG);
    g.fillRect(bar_x, bar_y, bar_width, bar_height);
    text = "You win!";
    text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
    g.setColor(VALUE);
    g.drawString(text, text_x, text_y);
}

}