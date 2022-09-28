import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private GreenfootImage background = getBackground();

    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        if (gameStarted)
        {
            
            background.setColor(Color.BLACK);

            // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            
            int randomPositionX = Greenfoot.getRandomNumber(200);
            int randomPositionY = Greenfoot.getRandomNumber(200) + 200;
            addObject(new Paddle(125,50, false), randomPositionX, WORLD_HEIGHT - randomPositionY);
            
            addObject(new Paddle(125,50,true), 60, WORLD_HEIGHT - 50);
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }}
    public void act()
    {
        background.drawString("Game Level: " + Integer.toString(Ball.speed), 20, 20);

    }

}