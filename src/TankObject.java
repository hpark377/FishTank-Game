//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Tank Object
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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import processing.core.PImage;

/**
 * This class makes TankObjects that goes inside the fish tank
 */
public class TankObject implements TankListener {
  private int health;
  protected static FishTank tank; // PApplet object which represents
  // the display window
  protected PImage image; // image of this tank object
  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window
  private boolean isDragging; // indicates whether this tank object
  // is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse
 

  /**
   * construct TankObject
   * 
   * @param x             :x-position of this TankOject
   * @param y             :y-position of this TankObject
   * @param imageFileName :filename of the image to be loaded for this object
   */
  public TankObject(float x, float y, String imageFileName) {
    this.image = tank.loadImage(imageFileName);
    this.x = x;
    this.y = y;
    isDragging = false;
  }

  public TankObject(float x, float y, String imageFileName, int health) {
    this.image = tank.loadImage(imageFileName);
    this.health = health;
    this.x = x;
    this.y = y;
    isDragging = false;
    ScheduledExecutorService execService = Executors.newScheduledThreadPool(1);
    execService.scheduleAtFixedRate(() -> {
        this.health--;
        if (this.health == 0) {
          System.out.println("shutdown");
          execService.shutdownNow();
        }
            
    }, 1L, 1L, TimeUnit.SECONDS); //initial delay, period, time unit
}
  

 

  /**
   * Sets the PApplet graphic display window for all TankObjects
   * 
   * @param tank : PApplet reference to the display window
   */
  public static void setProcessing(FishTank tank) {
    TankObject.tank = tank;
  }

  /**
   * Moves this tank object with dx and dy
   * 
   * @param dx: move to the x-position of this tank object
   * @param dy: move to the y-position of this tank object
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  /**
   * get the x position of the object
   * 
   * @return the x-position of this tank object
   */
  public float getX() {
    return x;
  }

  /**
   * get the y position of the object
   * 
   * @return the y-position of this tank object
   */
  public float getY() {
    return y;
  }

  /**
   * Sets the x-position of this object
   * 
   * @param x: the intend position of the object
   */
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Sets the y-position of this object
   * 
   * @param y: the intend position of the object
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * get image
   * 
   * @return the image of this tank object
   */
  public PImage getImage() {
    return image;
  }

  /**
   * Getter of the isDragging field.
   * 
   * @return true if this object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this tank object
   */
  public void startDragging() {
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    this.isDragging = true;
  }

  /**
   * Stops dragging this tank object
   */
  public void stopDragging() {
    this.isDragging = false;
  }

  /**
   * Draws this object to the display window. This method sets also the position of this object to
   * follow the moves of the mouse if it is being dragged
   */
  @Override
  public void draw() {
    // TODO Auto-generated method stub
    if (this.isDragging) {
      int dx = tank.mouseX - oldMouseX;
      int dy = tank.mouseY - oldMouseY;
      move(dx, dy);
      oldMouseX = tank.mouseX;
      oldMouseY = tank.mouseY;
    }

    // draw this object at its current position
    tank.image(this.image, this.x, y);

  }

  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    // TODO Auto-generated method stub
    for (int i = 0; i < tank.objects.size(); i++) {
      if (tank.objects.get(i).isMouseOver()) {
        ((TankObject) tank.objects.get(i)).startDragging();
        return;
        // only the object at the lowest index will start dragging if there are other objects
        // overlapping
      }
    }

  }

  /**
   * Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    // TODO Auto-generated method stub
    for (int i = 0; i < tank.objects.size(); i++) {
      if (tank.objects.get(i) instanceof TankObject) {
        ((TankObject) tank.objects.get(i)).stopDragging();
      }
    }

  }

  /**
   * Checks whether the mouse is over this object
   * 
   * @return true if the mouse is in the bound of size of the object
   */
  @Override
  public boolean isMouseOver() {
    // TODO Auto-generated method stub
    // checks if the mouse is over this object
    return tank.mouseX >= x - image.width / 2 && tank.mouseX <= x + image.width / 2
        && tank.mouseY >= y - image.height / 2 && tank.mouseY <= y + image.height / 2;
  }

  public boolean isDead() {
    return health == 1;
  }

}
