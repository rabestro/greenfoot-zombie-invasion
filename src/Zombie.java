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
        int front = getImage().getWidth()/2;
        int i = 1;
        while(i<=step) {
            List<Actor> a = getObjectsAtOffset(front+i,0,Actor.class);
            if( a.size() > 0 ) {
                for(int j=0;j<a.size()&&a.get(j) instanceof Zombie;j++){
                    int toss = Greenfoot.getRandomNumber(100) < 50 ? 1 : -1;
                    Zombie z = (Zombie) a.get(j);
                    z.setLocation(z.getX(),z.getY()+toss);
                }
                return false;
            }
            i++;
        }
        return true;
    }
}
