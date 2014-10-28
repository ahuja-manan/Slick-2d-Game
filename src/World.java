/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: <Manan Ahuja> <mahuja>
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Vector;;

/** Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World
{
	private static final int PLAYER_START_X = 756, PLAYER_START_Y = 684;
	
	//Defining instance variables for this class 
	private TiledMap map;
	private Player player;
	private Camera camera;
	//Vectors that will contain all the villagers, monsters and items 
	private Vector <Villager> villagers = new Vector <Villager>();
	private Vector <Monster> monsters = new Vector <Monster>();
	private Vector <Item> items = new Vector <Item>();
	private Vector <Item> inventory = new Vector <Item>();
	

	
    /**
     * Create a new World object
     * @throws SlickException
     */
    public World()
    throws SlickException
    {
       map = new TiledMap("assets/map.tmx", "assets");
       
       player = new Player(PLAYER_START_X, PLAYER_START_Y);
       
       camera = new Camera(player, RPG.screenwidth, RPG.screenheight); 
       
       villagers.addElement(new Prince(467, 679));
       villagers.addElement(new Elvira(738, 549));
       villagers.addElement(new Garth(756, 870));
       
       monsters.addElement(new GiantBat(1431,864));
       monsters.addElement(new GiantBat(1154,1321));
       monsters.addElement(new GiantBat(807,2315));
       monsters.addElement(new GiantBat(833,2657));
       monsters.addElement(new GiantBat(1090,3200));
       monsters.addElement(new GiantBat(676,3187));
       monsters.addElement(new GiantBat(836,3966));
       monsters.addElement(new GiantBat(653,4367));
       monsters.addElement(new GiantBat(1343,2731));
       monsters.addElement(new GiantBat(1835,3017));
       monsters.addElement(new GiantBat(1657,3954));
       monsters.addElement(new GiantBat(1054,5337));
       monsters.addElement(new GiantBat(801,5921));
       monsters.addElement(new GiantBat(560,6682));
       monsters.addElement(new GiantBat(1275,5696));
       monsters.addElement(new GiantBat(1671,5991));
       monsters.addElement(new GiantBat(2248,6298));
       monsters.addElement(new GiantBat(2952,6373));
       monsters.addElement(new GiantBat(3864,6695));
       monsters.addElement(new GiantBat(4554,6443));
       monsters.addElement(new GiantBat(4683,6228));
       monsters.addElement(new GiantBat(5312,6606));
       monsters.addElement(new GiantBat(5484,5946));
       monsters.addElement(new GiantBat(6371,5634));
       monsters.addElement(new GiantBat(5473,3544));
       monsters.addElement(new GiantBat(5944,3339));
       monsters.addElement(new GiantBat(6301,3414));
       monsters.addElement(new GiantBat(6388,1994));
       monsters.addElement(new GiantBat(6410,1584));
       monsters.addElement(new GiantBat(5314,274));
       
       monsters.addElement(new Zombie(681,3201));
       monsters.addElement(new Zombie(691,4360));
       monsters.addElement(new Zombie(2166,2650));
       monsters.addElement(new Zombie(2122,2725));
       monsters.addElement(new Zombie(2284,2962));
       monsters.addElement(new Zombie(2072,4515));
       monsters.addElement(new Zombie(2006,4568));
       monsters.addElement(new Zombie(2385,4629));
       monsters.addElement(new Zombie(2446,4590));
       monsters.addElement(new Zombie(2517,4532));
       monsters.addElement(new Zombie(4157,6730));
       monsters.addElement(new Zombie(4247,6620));
       monsters.addElement(new Zombie(4137,6519));
       monsters.addElement(new Zombie(4234,6449));
       monsters.addElement(new Zombie(5879,4994));
       monsters.addElement(new Zombie(5954,4928));
       monsters.addElement(new Zombie(6016,4866));
       monsters.addElement(new Zombie(5860,4277));
       monsters.addElement(new Zombie(5772,4277));
       monsters.addElement(new Zombie(5715,4277));
       monsters.addElement(new Zombie(5653,4277));
       monsters.addElement(new Zombie(5787,797));
       monsters.addElement(new Zombie(5668,720));
       monsters.addElement(new Zombie(5813,454));
       monsters.addElement(new Zombie(5236,917));
       monsters.addElement(new Zombie(5048,1062));
       monsters.addElement(new Zombie(4845,996));
       monsters.addElement(new Zombie(4496,575));
       monsters.addElement(new Zombie(3457,273));
       monsters.addElement(new Zombie(3506,779));
       monsters.addElement(new Zombie(3624,1192));
       monsters.addElement(new Zombie(2931,1396));
       monsters.addElement(new Zombie(2715,1326));
       monsters.addElement(new Zombie(2442,1374));
       monsters.addElement(new Zombie(2579,1159));
       monsters.addElement(new Zombie(2799,1269));
       monsters.addElement(new Zombie(2768,739));
       
       monsters.addElement(new Bandit(2099,956));
       monsters.addElement(new Bandit(1889,2581));
       monsters.addElement(new Bandit(4502,6283));
       monsters.addElement(new Bandit(5248,6581));
       monsters.addElement(new Bandit(5345,6678));
       monsters.addElement(new Bandit(5940,3412));
       monsters.addElement(new Bandit(6335,3459));
       monsters.addElement(new Bandit(6669,260));
       monsters.addElement(new Bandit(6598,339));
       monsters.addElement(new Bandit(6598,528));
       monsters.addElement(new Bandit(6435,528));
       monsters.addElement(new Bandit(6435,678));
       monsters.addElement(new Bandit(5076,1082));
       monsters.addElement(new Bandit(5191,1187));
       monsters.addElement(new Bandit(4940,1175));
       monsters.addElement(new Bandit(4760,1039));
       monsters.addElement(new Bandit(4883,889));
       monsters.addElement(new Bandit(4427,553));
       monsters.addElement(new Bandit(3559,162));
       monsters.addElement(new Bandit(3779,1553));
       monsters.addElement(new Bandit(3573,1553));
       monsters.addElement(new Bandit(3534,2464));
       monsters.addElement(new Bandit(3635,2464));
       monsters.addElement(new Bandit(3402,2861));
       monsters.addElement(new Bandit(3151,2857));
       monsters.addElement(new Bandit(3005,2997));
       monsters.addElement(new Bandit(2763,2263));
       monsters.addElement(new Bandit(2648,2263));
       monsters.addElement(new Bandit(2621,1337));
       monsters.addElement(new Bandit(2907,1270));
       monsters.addElement(new Bandit(2331,598));
       monsters.addElement(new Bandit(2987,394));
       monsters.addElement(new Bandit(1979,394));
       monsters.addElement(new Bandit(2045,693));
       monsters.addElement(new Bandit(2069,1028));
       
       monsters.addElement(new Skeleton(1255,2924));
       monsters.addElement(new Skeleton(2545,4708));
       monsters.addElement(new Skeleton(4189,6585));
       monsters.addElement(new Skeleton(5720,622));
       monsters.addElement(new Skeleton(5649,767));
       monsters.addElement(new Skeleton(5291,312));
       monsters.addElement(new Skeleton(5256,852));
       monsters.addElement(new Skeleton(4790,976));
       monsters.addElement(new Skeleton(4648,401));
       monsters.addElement(new Skeleton(3628,1181));
       monsters.addElement(new Skeleton(3771,1181));
       monsters.addElement(new Skeleton(3182,2892));
       monsters.addElement(new Skeleton(3116,3033));
       monsters.addElement(new Skeleton(2803,2901));
       monsters.addElement(new Skeleton(2850,2426));
       monsters.addElement(new Skeleton(2005,1524));
       monsters.addElement(new Skeleton(2132,1427));
       monsters.addElement(new Skeleton(2242,1343));
       monsters.addElement(new Skeleton(2428,771));
       monsters.addElement(new Skeleton(2427,907));
       monsters.addElement(new Skeleton(2770,613));
       monsters.addElement(new Skeleton(2915,477));
       monsters.addElement(new Skeleton(1970,553));
       monsters.addElement(new Skeleton(2143,1048));
       
       monsters.addElement(new Draelic(2069,510)); 
       
       items.addElement(new Amulet(965, 3563));
       items.addElement(new Sword(900, 800));
       items.addElement(new Tome(546, 6707));
       items.addElement(new Elixir(1000, 702));    
    }
    
    /** Update the game state for a frame.
     * @param dir_x   The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y   The player's movement in the y axis (-1, 0 or 1).
     * @param attack  Variable to know if key A was pressed.
     * @param talk	  Variable to know if key T was pressed.
     * @param delta   Time passed since last frame (milliseconds).
     */
    public void update(double dir_x, double dir_y, double attack, double talk, int delta)
    throws SlickException
    {	
    	/** Call update functions of player, camera and monsters */
    	player.update(this, dir_x, dir_y, attack, talk, delta, villagers, monsters, items, inventory); 
    	camera.followUnit(player);
    	camera.update();
        for(int i=0; i<monsters.size(); i++){
        	monsters.elementAt(i).update(this, player, delta);
        }
    }

    
	/** Check if the current tile is supposed to block the unit or not.
	 * @param xCoord The current X coordinate of the unit.
	 * @param yCoord The current Y coordinate of the unit.
	 * @return true if unit is supposed to be blocked on
	 * the current tile and false otherwise.
	 */
	public boolean terrainBlock(double xCoord, double yCoord)
	throws SlickException
	{
		int tileId;
		String tileProperty;
		
		tileId = map.getTileId((int)(xCoord/72), (int)(yCoord/72), 0);
		tileProperty = map.getTileProperty(tileId, "block", "0");
		return tileProperty.equals("1");
	}
    
    /** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
    throws SlickException
    {	//The X and Y offsets of where the rendering should begin from. 
    	
    	int xOffset = camera.getxPos()%RPG.TILE_WIDTH;
    	int yOffset = camera.getyPos()%RPG.TILE_HEIGHT;
    	
    	// The tile numbers of where the rendering should begin from. 
    	int xTileNo = camera.getxPos()/RPG.TILE_WIDTH; 
    	int yTileNo = camera.getyPos()/RPG.TILE_HEIGHT;
    	
    	
    	//Render the map using the values of the variables above. 
        map.render(-xOffset,-yOffset,xTileNo, yTileNo, 13, 10);
        //Use translate() to bring everything to context
        g.translate(-camera.getxPos(), -camera.getyPos());
        //Call render functions of all the different units
        player.render(g);
        for(int i=0; i<villagers.size(); i++){
        	villagers.elementAt(i).render(g);
        }
        for(int i=0; i<monsters.size(); i++){
        	monsters.elementAt(i).render(g);
        }
        
        for(int i=0; i<items.size(); i++){
        	items.elementAt(i).render(g);
        }
        //Reset the translate and then render status bar
        g.resetTransform();
        renderPanel(g);

        }
    
    /** Renders the player's status panel.
     * @param g The current Slick graphics context.
     */
    public void renderPanel(Graphics g)
    {
        // Panel colours
        Color LABEL = new Color(0.9f, 0.9f, 0.4f);          // Gold
        Color VALUE = new Color(1.0f, 1.0f, 1.0f);          // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);   // Black, transp
        Color BAR = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

        // Variables for layout
        String text;                // Text to display
        int text_x, text_y;         // Coordinates to draw text
        int bar_x, bar_y;           // Coordinates to draw rectangles
        int bar_width, bar_height;  // Size of rectangle to draw
        int hp_bar_width;           // Size of red (HP) rectangle
        int inv_x, inv_y;           // Coordinates to draw inventory item

        float health_percent;       // Player's health, as a percentage

        // Panel background image
        player.getPanel().draw(0, RPG.screenheight - RPG.PANELHEIGHT);

        // Display the player's health
        text_x = 15;
        text_y = RPG.screenheight - RPG.PANELHEIGHT + 25;
        g.setColor(LABEL);
        g.drawString("Health:", text_x, text_y);
        text = player.getHP() + "/" + player.getMaxHP();                 

        bar_x = 90;
        bar_y = RPG.screenheight - RPG.PANELHEIGHT + 20;
        bar_width = 90;
        bar_height = 30;
        health_percent = ((float)player.getHP()/player.getMaxHP());              
        hp_bar_width = (int) (bar_width * health_percent);
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's damage and cooldown
        text_x = 200;
        g.setColor(LABEL);
        g.drawString("Damage:", text_x, text_y);
        text_x += 80;
        text = "" + player.getDamage();                                    
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
        text_x += 40;
        g.setColor(LABEL);
        g.drawString("Rate:", text_x, text_y);
        text_x += 55;
        text = "" + player.getCooldown();                   
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's inventory
        g.setColor(LABEL);
        g.drawString("Items:", 420, text_y);
        bar_x = 490;
        bar_y = RPG.screenheight - RPG.PANELHEIGHT + 10;
        bar_width = 288;
        bar_height = bar_height + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);

        inv_x = 490;
        inv_y = RPG.screenheight - RPG.PANELHEIGHT + ((RPG.PANELHEIGHT - 72) / 2);
        for(int i=0; i<inventory.size(); i++)
        {
            Image item = inventory.elementAt(i).getImg();
            item.draw(inv_x, inv_y);
            inv_x += 72;
        }
    }
	
}
