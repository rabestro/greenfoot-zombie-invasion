import java.util.List;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Zombie extends Actor
{
    int counter = 0;
    int stationaryX;
    int amplitude;
    private int step = 4;
    
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
    
    private boolean canMarch() {
        int i=0;
        while(i<=step) {
            int front = getImage().getWidth()/2;
            Actor a = getOneObjectAtOffset(i+front, 0, Actor.class);
            if( a != null ) {
                return false;
            }
            i++;
        }
        return true;
    }
}
