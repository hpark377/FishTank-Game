


public class Gold extends TankObject {
  // value of the coin
  private int goldPoint;
  
  public Gold(float x, float y, String filename, int goldPoint) {
    super(x, y, filename, 10);  
    this.goldPoint = goldPoint;
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
        GoldCounter.total = GoldCounter.total + goldPoint;
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
  
}
