import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Boom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boom extends Actor
{
    private static final int BOOMLIFE = 50;
    private static final int BOOMRADIUS = 50;
    int boomCounter = BOOMLIFE;
    
    public Boom() {
        GreenfootImage me = new GreenfootImage(BOOMRADIUS*2,BOOMRADIUS*2);
        me.setColor(Color.RED);
        me.setTransparency(125);
        me.fillOval(0 , 0, BOOMRADIUS * 2, BOOMRADIUS*2);
        setImage(me);
    }
    
    /**
     * Act - do whatever the Boom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( boomCounter == BOOMLIFE) {
            destroyEverything(BOOMRADIUS);
        }
            
        if( boomCounter-- == 0 ) {
            World w = getWorld();
            w.removeObject(this);
        }
    }    
    
    private void destroyEverything(int x) {
        List<Actor> objs = getObjectsInRange(x, Actor.class);
        World w = getWorld();
        w.removeObjects(objs);
    }
}
