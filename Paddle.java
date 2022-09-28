import greenfoot.*;
import java.util.List;
import java.util.ArrayList;


/**
 * A paddle is an object that goes back and forth. 
 *
 * @author LukasH0lm 
 * @version 3
 */
public class Paddle extends Actor
{
    private int width;
    private int height;
    public int dx;
    public boolean isPlayerControlled;
    public boolean isOpponent;
    public static boolean isChasing = true;
    private List<Ball> chasedBall;
    private GreenfootImage baguette;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height, boolean isPlayerControlled, boolean isOpponent)
    {
        this.width = width;
        this.height = height;
        this.isPlayerControlled = isPlayerControlled;
        this.isOpponent = isOpponent;

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
        
            if(!isOpponent){
            
            tryChangeDirection();
            setLocation(getX() + dx, getY());

        }else{
            if(isChasing){
            
            chasedBall= getObjectsInRange(1000,Ball.class);
            //chasedBall.add(null); //for at undgå IndexOutOfBoundsException

            if (chasedBall.get(0).getX() > 400){
            
            setLocation(getX() + 2, getY());

        } else if (chasedBall.get(0).getX() < 200){
        
            setLocation(getX() -2, getY());
        }else{
            moveToMiddle();
        }
        
    }else{
        moveToMiddle();
    
}}}}

    /**
     * Will rotate the paddle 180 degrees if the paddle is at worlds edge.
     */
    private void tryChangeDirection()
    {
        //Check to see if we are touching the outer boundaries of the world:
        // IF we are touching the right boundary OR we are touching the left boundary:
        if(getX() + width/2 >= getWorld().getWidth()|| getX() - width/2 <= 0 )
        {
            //Change our 'x' direction to the inverted direction:
            int y = Greenfoot.getRandomNumber(300) + 200;
            setLocation(50 , y);
            int x = Greenfoot.getRandomNumber(75) + 75;

            this.width = x;
            this.baguette.scale(x,50);

        }
    }

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        baguette = new GreenfootImage("Baguette.png");
        setImage(baguette);
        baguette.scale(150,50);
    }

    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left")){
            dx = -3;
        }else if (Greenfoot.isKeyDown("right")){
            dx = 3;
        }else{
            dx = 0;
        
        }
        
        
        setLocation(getX() + dx, getY());

    }
    private void moveToMiddle(){
        if (this.getX() < 250){
            
            dx = 2;

        } else if (this.getX() > 350){
        
            dx = -2;
        
        }else{
        
            dx = 0;
        
        }
        
        setLocation(getX() + dx, getY());
    
        
    }

}
