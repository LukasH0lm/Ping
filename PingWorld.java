import greenfoot.*;


/**
 * The Ping World is where Balls and Paddles meet to play ping.
 * 
 * @author LukasH0lm 
 * @version 2
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private GreenfootImage background = getBackground();
    public static int playerScore = 0;
    public static int aiScore = 0;

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
            //addObject(new Paddle(125,50, false), randomPositionX, WORLD_HEIGHT - randomPositionY);
            
            addObject(new Paddle(150,50, false, true), 60, 50);
            addObject(new Paddle(150,50,false, false ), 60, WORLD_HEIGHT / 2);
            addObject(new Paddle(150,50,true, false), 60, WORLD_HEIGHT - 50);

            playerScore = 0;
            aiScore = 0;
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }}
    public void act()
    {
        showText(Integer.toString(aiScore), 25, 100);
        showText(Integer.toString(playerScore), 25, 600);
        if (aiScore == 10 || playerScore == 10){
        gameover();
        }

    }
    public void gameover(){
         Greenfoot.setWorld(new GameOverWorld());
    }
}
