//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Orange Fish Button
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
 * this class creates button for orange fish
 *
 */
public class AddOrangeFishButton extends Button{
  
  /**
   * constructor that creates button with text "add orange" 
   * @param x x position of the button
   * @param y y position of the button
   */
  public AddOrangeFishButton(float x, float y) {
    // TODO Auto-generated constructor stub
    super("Add Orange",x , y);
  }
  
  /**
   * overrides mousepressed from class button
   * if pressed add orange fish in array list
   */
  @Override
  public void mousePressed() {
    // TODO Auto-generated method stub
    super.mousePressed();
    try {
      GoldCounter.subtract(100);
      OrangeFish orange = new OrangeFish();
      tank.addObject(orange);
      orange.appear();
    } catch (ArithmeticException ae) {} 
  }

}
