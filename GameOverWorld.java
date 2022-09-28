import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOverWorld. a world that shows when the game is over
 * 
 * @author LukasH0lm
 * @version 1
 */
public class GameOverWorld extends World
{

    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        super(500, 700, 1); 
        if (PingWorld.playerScore == 10){
        setBackground("WinScreen.png");
        Greenfoot.playSound("Fantastique.wav");

    } else{
        setBackground("LoseScreen.png");
        Greenfoot.playSound("SiTris.wav");


    }
    }
    
    public void act()
    {
        
        showText("Score: " + Integer.toString(Ball.speed), 250, 350);

        
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Ball.speed = 1;
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
    
}
