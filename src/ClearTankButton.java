//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: clear button 
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
 * this class creates button for clearing fishes
 *
 */
public class ClearTankButton extends Button{
  
  /**
   * constructor that creates button with text "clear" 
   * @param x x position of the button
   * @param y y position of the button
   */
  public ClearTankButton(float x, float y) {
    super("clear", x, y);
  }
  
  /**
   * overrides mousedpressed() from class button
   * if pressed remove every fish in array list
   */
  @Override
  public void mousePressed() {
    // TODO Auto-generated method stub
    super.mousePressed();
    for (int i = 0; i < tank.objects.size(); i++) {
      if(tank.objects.get(i) instanceof Fish) {
        ((Fish)tank.objects.get(i)).disappear();
        tank.objects.remove(i);
        i--;
      } 
    }
  }
}
