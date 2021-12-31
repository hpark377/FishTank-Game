//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//
// Title: Tank Listener
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

/**
 * interface for tank object and button
 */
public interface TankListener {
  
  /**
   * draws this tank object to the display window
   */
  public void draw();
  
  /**
   * called each time the mouse is Pressed
   */
  public void mousePressed();
  
  /**
   * called each time the mouse is Released
   * public void mouseReleased();
   */
  public void mouseReleased();
   
   /**
   * checks whether the mouse is over this Tank GUI
   * return true if the mouse is over this tank GUI object, false otherwise
   */
  public boolean isMouseOver();

}
