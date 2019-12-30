import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    int counter = 0;
    int stationaryX;
    int amplitude;
    
    protected void addedToWorld(World w) {
        stationaryX = getX();
        amplitude = Greenfoot.getRandomNumber(6) + 2;
    }
    
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shake();
        if( canMarch() ) {
            stationaryX = stationaryX + 2;
        }
    }    
    
    public void shake() {
        counter++;
        setLocation((int)(stationaryX + amplitude*Math.sin(counter/2)), getY());
    }
    
    public boolean canMarch() {
        List<Actor> things = getIntersectingObjects(Actor.class);
        for( int i = 0; i < things.size(); i++ ) {
            if( things.get(i).getX() > getX() + 20 ) {
                return false;
            }
        }
        return true; 
    }
}
