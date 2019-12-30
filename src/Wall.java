import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor {
    int wallStrength = 2000;
    int wallStage = 0;

    public void act() {
        crumble();
    }
    
    private void crumble() {
        List<Zombie> army = getIntersectingObjects(Zombie.class);
        wallStrength = wallStrength - army.size();
        if( wallStrength < 0 ) {
            wallStage++;
            if( wallStage > 4 ) {
                World w = getWorld();
                w.removeObject(this);
            }
            else {
                changeImage();
                wallStrength = 2000;
            }
        }
    }
    private void changeImage() {
        setImage("brick"+wallStage+".jpg");
    }
}