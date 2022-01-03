//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Blue Fish Button
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
///////////////////////////////////////////////////////////////////////////////
import java.io.File;

/**
 * this class creates bluefish objects
 */
public class BlueFish extends Fish{
  
  /**
   * Constructor that uses the blue fish image 
   */
  BlueFish(){
    super(2,"images" + File.separator + "blue.png",10);
  }
  
  /**
   * move the fish to the left
   * if the fish meets the left end appear on the right side of the tank.
   * overrides fish.swim()
   */
  @Override
  public void swim() {
    this.setX(this.getX()-this.speed());
    //when the fish reaches the end of the left side(position 0) make it appear on the right side
    if(this.getX() < 0) {
      this.setX(tank.width);
    }
  }
}
  

