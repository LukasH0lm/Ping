import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 *
 * @author The teachers 
 * @version 1
 */
public class Paddle extends Actor
{
    private int width;
    private int height;
    private int dx;
    public boolean isPlayerControlled;


    private GreenfootImage baguette;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height, boolean isPlayerControlled)
    {
        this.width = width;
        this.height = height;
        this.isPlayerControlled = isPlayerControlled;
        dx = 1;
        createImage();

    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isPlayerControlled){
            checkKeyPress();

        }else{
            tryChangeDirection();
            setLocation(getX() + dx, getY());


        }
    }

    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void tryChangeDirection()
    {
        //Check to see if we are touching the outer boundaries of the world:
        // IF we are touching the right boundary OR we are touching the left boundary:
        if(getX() + width/2 >= getWorld().getWidth() + 40|| getX() - width/2 <= 0 - 40)
        {
            //Change our 'x' direction to the inverted direction:
            int y = Greenfoot.getRandomNumber(100) + 200;
            setLocation(50 , y);
        }
    }

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        baguette = new GreenfootImage("Baguette.png");
        setImage(baguette);
    }

    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 3, getY());
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 3, getY());
        }

    }

}
