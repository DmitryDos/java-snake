import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GameField extends JPanel implements KeyListener, ActionListener {
  private Timer timer;
  private Snake snake;
  private Apple apple;
  private TextBox textBox;

  public GameField() {

    snake = new Snake();

    apple = new Apple();
    apple.generateApple();

    textBox = new TextBox();

    setFocusable(true);
    addKeyListener(this);

    timer = new Timer(100, this);
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    snake.draw(g);
    apple.draw(g);
    textBox.draw(g, 720, 5, 75, 25, 8, 16, "Score: " + snake.getLength());
    if(!timer.isRunning()) {
      textBox.draw(g, 300, 325, 200, 50, 8, 32,"You lose!");
    }
  }
  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case 37 -> {
        if (snake.getDirection() != Snake.Directions.RIGHT) {
          snake.changeDirection(Snake.Directions.LEFT);
        }
      }
      case 38 -> {
        if (snake.getDirection() != Snake.Directions.DOWN) {
          snake.changeDirection(Snake.Directions.UP);
        }
      }
      case 39 -> {
        if (snake.getDirection() != Snake.Directions.LEFT) {
          snake.changeDirection(Snake.Directions.RIGHT);
        }
      }
      case 40 -> {
        if (snake.getDirection() != Snake.Directions.UP) {
          snake.changeDirection(Snake.Directions.DOWN);
        }
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void actionPerformed(ActionEvent e) {
    snake.move();
    snake.checkApple(apple);
    if (snake.checkBorders()) {
      timer.stop();
    }
    repaint();
  }
}
