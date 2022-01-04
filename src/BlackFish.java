//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Black Fish
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

/**
 * this class makes black fish which is the child class object of fish
 */
public class BlackFish extends Fish {
  //private data fields
  private TankObject source;
  private TankObject destination;

  /**
   * black fish constructor that takes to tank objects as parameters.
   * @param source 
   * @param destination
   */
  public BlackFish(TankObject source, TankObject destination) {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
  }
  
  /**
   * makes the black fish move towards destination with speed
   */ 
  public void moveTowardsDestination() {
    //old position of the fish
    float oldX = this.getX();
    float oldY = this.getY();
    //the movement between x coordinate and y coordinate 
    float dx = destination.getX() - oldX;
    float dy = destination.getY() - oldY;
    //the distance the fish has moved
    int distance = (int)Math.sqrt(dx*dx + dy*dy);
    this.setX(oldX + this.speed()*dx/distance);
    this.setY(oldY + this.speed()*dy/distance);
  }

  /**
   * check if the 2 objects overlap
   * @param other, see if black fish meets the tank object other  
   * @return true if this black fish is over another tank object, and false otherwise
   */
  public boolean isOver(TankObject other) {
    // boundaries of the fish object and other object
    float x1 = this.getX() - this.getImage().width/2;
    float x2 = this.getX() + this.getImage().width/2;
    float y1 = this.getY() - this.getImage().height/2;
    float y2 = this.getY() + this.getImage().height/2;
    float x3 = other.getX() - other.getImage().width/2;
    float x4 = other.getX() + other.getImage().width/2;
    float y3 = other.getY() - other.getImage().height/2;
    float y4 = other.getY() + other.getImage().height/2;
    // condition of overlaps
    return (x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2);
  }

  
  /**
   * move the fish towards its destination
   * if destination is reached (meaning this fish is over its destination,
   * switch source and destination
   * overrides fish.swim()
   */
  @Override
  public void swim() {
    moveTowardsDestination();
    if(isOver(destination) == true) {
      //switch source and destination when overlap
      TankObject temp = null;
      temp = source;
      source = destination;
      destination = temp;
    }
  }

}
