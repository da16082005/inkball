package inkball;

import processing.core.PImage;
import java.util.Random;

public class Ball {
  public static final int BALL_WIDTH = 24;
  public static final int BALL_HEIGHT = 24;
  private int x;
  private int y;
  private int xByTile;
  private int yByTile;
  private String color;
  private float xSpeed;
  private float ySpeed;

  public Ball(int xByTile, int yByTile, String color, float xSpeed, float ySpeed) {
    this.xByTile = xByTile;
    this.x = xByTile * App.CELLSIZE + 4;

    this.yByTile = yByTile;
    this.y = yByTile * App.CELLSIZE + App.TOPBAR + 4;

    this.color = color;

    Random rand = new Random();
    this.xSpeed = rand.nextInt(5) - 2;
    this.ySpeed = rand.nextInt(5) - 2;
  }

  public void draw(App app) {
    PImage ball = app.getSprite(color);

    app.image(ball, x, y);

    // update the ball's position
    x += xSpeed;
    y += ySpeed;

    // check for bouncing on x edges
    if (x > App.WIDTH - BALL_WIDTH || x < 0) {
      xSpeed *= -1;
    }

    // check for bouncing on y edges
    if (y > App.HEIGHT - BALL_HEIGHT || y < App.TOPBAR) {
      ySpeed *= -1;
    }
  }
}
