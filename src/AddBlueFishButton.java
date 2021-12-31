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

 /**
 * this class creates button for bluefish
 *
 */
public class AddBlueFishButton extends Button{
  
 /**
 * constructor that creates button with text "add blue" 
 * @param x x position of the button
 * @param y y position of the button
 */
  public AddBlueFishButton(float x, float y) {
    super("Add Blue", x, y);
    
  }
  
  /**
   * overrides mousedpressed() from class button
   * if pressed add bluefish in array list
   */
  @Override
  public void mousePressed() {
    super.mousePressed();
    tank.addObject(new BlueFish()); 
  }
  

}
