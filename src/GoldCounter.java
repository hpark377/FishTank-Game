
public class GoldCounter implements TankListener {


  private static final int WIDTH = 85; // Width of this Button
  private static final int HEIGHT = 32; // Height of this Button
  protected static FishTank tank; // PApplet object where this button will be displayed
  private float x; // x-position of this button in the display window
  private float y; // y-position of this button in the display window
  protected String label; // text/label which represents this button
  protected static int total;

  public GoldCounter(float x, float y) {
    this.x = x;
    this.y = y;
    this.label = total + " G";
  }


  public static void setProcessing(FishTank tank) {
    GoldCounter.tank = tank;
  }

  public void draw() {
    this.label = total + " G";
    tank.stroke(0);// set line value to black
    tank.fill(200);
    // draw the button (rectangle with a centered text)
    tank.rect(x - WIDTH / 1.0f, y - HEIGHT / 2.0f, x + WIDTH / 1.0f, y + HEIGHT / 2.0f);
    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button
    
  }

  @Override
  public void mousePressed() {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isMouseOver() {
    // TODO Auto-generated method stub
    return false;
  }



}
