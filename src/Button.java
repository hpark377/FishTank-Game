//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Button
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
/**
 * this class makes button objects and implements interface TankListener
 *
 */
public class Button implements TankListener {
  
  private static final int WIDTH = 85; // Width of this Button
  private static final int HEIGHT = 32; // Height of this Button
  protected static FishTank tank; // PApplet object where this button will be displayed
  private float x; // x-position of this button in the display window
  private float y; // y-position of this button in the display window
  protected String label; // text/label which represents this button
  
  /**
   * Creates a new Button at a given position within the display window
   * sets its label
   * @param label string that appears on the button
   * @param x x position of the button
   * @param y y position of the button
   */
  public Button(String label, float x, float y) {
    this.x = x;
    this.y = y;
    this.label = label;
  }

  /**
   * sets the he PApplet display window where this button is displayed and handled
   * @param tank is the PApplet that is going to display the button
   */ 
  public static void setProcessing(FishTank tank) {
    Button.tank = tank;
  }

 
  /**
   * Overrides the TankListener.isMouseOver() method
   * Checks whether the mouse is over this button
   * @return true if the mouse is over this button, false otherwise.
   */
  @Override
  public boolean isMouseOver() {
    // The implementation of this behavior must be similar to the way to check whether
    // the mouse is over an image. The button is a rectangle whose x,y position is at
    // its center. The width and height of a button are defined as static data fields.
    return tank.mouseX >= this.x - WIDTH / 2 && tank.mouseX <= this.x + WIDTH / 2
        && tank.mouseY >= this.y - HEIGHT / 2 && tank.mouseY <= this.y + HEIGHT / 2;
  }
  
  /**
   * Overrides TankListener.draw() method
   * Draws this button to the display window
   */
  public void draw() {
    tank.stroke(0);// set line value to black

    // TODO if the mouse is over this button, sets the fill color to dark gray.
    // Sets the fill color to light gray otherwise
    if(this.isMouseOver()) {
      tank.fill(100);
    }
    else tank.fill(200);

    // draw the button (rectangle with a centered text)
    tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button
  }

  
  /**
   * Overrides the TankListener.mousePressed() method
   * Implements the default behavior of this button when the mouse is pressed. This method must be
   * overridden in the sub-classes to implement a specific behavior if needed.
   */
  @Override
  public void mousePressed() {
    // TODO if the mouse is over this button, print
    // "A button was pressed." to the console
    if(this.isMouseOver()) {
      System.out.println("A button was pressed.");
    }

  }

  /**
   * Overrides the TankListener.mouseReleased() method
   * Implements the default behavior of this button when the mouse is released.
   * This method must be overridden in the sub-classes to implement a specific behavior if needed.
   */
  public void mouseReleased() {
    // Leave this method empty
  }



}
