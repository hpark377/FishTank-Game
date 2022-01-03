import java.io.File;


public class Gold extends TankObject {
  // value of the coin
  private int goldPoint = 100;
  private int total = 0;
  
  public Gold(float x, float y) {
    super(x, y, "images" + File.separator + "gold.png");  
  }
  
  @Override
  public void draw() {
    // TODO Auto-generated method stub
    super.draw();
    if(isFalling()) {
      fall();
    }
  }
  
  //disappears when clicked
  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    
    for (int i = 0; i < tank.objects.size() ; i++) {
      if (tank.objects.get(i).isMouseOver()) {
        tank.objects.remove(i);
        return;
      }
    } 
  }
  
  public void fall() {
    this.setY((this.getY() + 2));
  }
  
  public boolean isFalling() {
    return this.getY() <= 550;
  }
  
  public int getTotal() {
    return total;
  }
  
}
