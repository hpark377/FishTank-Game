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
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class makes fish that goes inside the fish tank extends superclass TankObject
 */
public class Fish extends TankObject {
  private int speed;
  private int cost;
  private boolean isSwimming;
  private boolean exist = true;

  /**
   * construct object Fish calls the super() constructor from TankObject
   * 
   * @param speed:             the swimming speed of this fish
   * @param fishImageFileName: file name of the image of the fish to be create
   */
  public Fish(int speed, String fishImageFileName, int health, int cost) {

    super(tank.randGen.nextInt(tank.width), tank.randGen.nextInt(tank.height), fishImageFileName, 10);
    if (speed <= 0) {
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    } else this.speed = speed;
    
    this.cost = cost;
    exist();
    timer();
  }


  /**
   * Overrides the draw() method implemented in the parent class. This method sets the position of
   * this fish to follow the mouse moves if it is dragging, calls its swim() method if it is
   * swimming, and draws it to the display window. draw() method of the super class and adds the
   * behavior specific to drawing a fish.
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
   * 
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
   * 
   * @return integer value speed
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

  public void goldDrop() {
    tank.addObject(new Gold(this.getX(), this.getY(), "images" + File.separator + "gold.png", 100));
  }

  public void timer() {

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        if (exist() == false) {
          System.out.println("Timer canceled");
          timer.cancel();
        }
        else {
          System.out.println("drop");
          goldDrop();
        }
        
      }
    };
    timer.scheduleAtFixedRate(task, 5000, 5000);

  }

  public boolean exist() {
    return exist;
  }

  public void appear() {
    this.exist = true;
  }

  public void disappear() {
    this.exist = false;
  }
  public int getCost() {
    return cost;
  }
}
