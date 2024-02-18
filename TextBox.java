import java.awt.*;

public class TextBox {

  public TextBox() {}

  public void draw(Graphics g, int cordX, int cordY, int sizeX, int sizeY, int marginX, int marginY, String text) {
    g.drawRect(cordX, cordY, sizeX, sizeY);
    g.drawString(text, cordX + marginX, cordY + marginY);
  }
}
