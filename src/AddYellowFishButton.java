//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Yellow Fish Button
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
 * this class creates button for yellow fish
 *
 */
public class AddYellowFishButton extends Button {
  
  /**
   * constructor that creates button with text "add yellow" 
   * @param x x position of the button
   * @param y y position of the button
   */
  public AddYellowFishButton(float x, float y) {
    super("Add Yellow", x, y);
  }
  
  
  /**
   * overrides mousepressed from class button
   * if pressed add yellow fish in array list
   */
  @Override
  public void mousePressed() {
    super.mousePressed();
    tank.objects.add(new Fish(2, "images" + File.separator + "yellow.png" ,10));
  }

}
