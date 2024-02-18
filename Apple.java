import java.awt.*;
import java.util.Random;

public class Apple {
  Random random = new Random();
  private int cordX = 400;
  private int cordY = 400;
  private int margin = 5;
  private int size = 15;
  public int getCordX() {
    return cordX;
  }

  public int getCordY() {
    return cordY;
  }

  public Apple() {}

  public Apple(int cordX, int cordY, int size) {
    this.cordX = cordX;
    this.cordY = cordY;
    this.size = size;
  }

  public void draw(Graphics g) {
    g.drawOval(cordX + margin, cordY + margin, size, size);
  }

  public void generateApple() {
    cordX = random.nextInt(30) * 25 + 25;
    cordY = random.nextInt(30) * 25 + 25;
    margin = random.nextInt(10);
  }
}
