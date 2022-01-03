//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Fish
// Course: CS 300 Fall 2021
//
// Author: Hyunmin Park
// Email: hpark377@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
////////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class makes fish that goes inside the fish tank extends superclass TankObject
 */
public class Fish extends TankObject{
  private int speed;
  private int health;
  private boolean isSwimming;
  
  /**
   * construct object Fish
   * calls the super() constructor from TankObject
   * @param speed: the swimming speed of this fish
   * @param fishImageFileName: file name of the image of the fish to be create
   */
  public Fish(int speed, String fishImageFileName, int health){
    
    super(tank.randGen.nextInt(tank.width), tank.randGen.nextInt(tank.height), fishImageFileName);
    if(speed <= 0) {
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    }
    else this.speed = speed;
    this.health = health;
     
    ScheduledExecutorService execService = Executors.newScheduledThreadPool(1);
    execService.scheduleAtFixedRate(() -> {
        System.out.println(this.health);
        this.health--;
        if(this.health == 0) execService.shutdownNow();
    }, 1L, 1L, TimeUnit.SECONDS);
  }
  /**
   * constructs default fish
   */
  public Fish(){
    this(5,"images" + File.separator + "orange.png",10);
  }
  
  /**
   * Overrides the draw() method implemented in the parent class.
   * This method sets the position of this fish to follow the
   * mouse moves if it is dragging, calls its swim() method
   * if it is swimming, and draws it to the display window.
   * draw() method of the super class and adds the behavior specific to drawing a fish.
   */
  @Override
  public void draw() {
    super.draw();
 // if the fish is swimming, call its swim() method
    if (isSwimming) {
      swim();
    }
  }

  /**
   * Checks whether this fish is swimming
   * @return boolean isSwimming
   */
  public boolean isSwimming() {
    return isSwimming;
  }
  
  /**
   * Starts swimming this fish
   */ 
  public void startSwimming() {
    this.stopDragging();
    this.isSwimming = true;
  }

  /**
   * Stops swimming this fish
   */
  public void stopSwimming() {
    this.isSwimming = false;
  }

  /**
   * Gets the speed of this fish
   * @return int value speed
   */
  public int speed() {
    return speed;
  }
  
  /**
   * Moves horizontally the fish one speed step from left to right.
   */
  public void swim() {
    this.setX((this.getX() + speed) % tank.width);
  }
  
  public boolean isDead() {
    return health == 1;
  }

}
