import greenfoot.*;

/**
 * IntroWorld. a start screen for the program
 *
 * @author LukasH0lm
 * @version 2
 */
public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    public GreenfootSound introMusik = new GreenfootSound("IntroMusik.wav");
    /**
     * Constructor for objects of class IntroWorld.
     */
    public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        setBackground("IntroScreen.png");
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        introMusik.play();
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            introMusik.stop();
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
    
}
