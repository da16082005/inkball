package inkball;

import processing.core.PConstants;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

class Wall extends Tile {
  private String color;

  public Wall(int x, int y, String color) {
    super(x, y);
    this.color = color; // wall0, or wall1
    this.is_covered= true;
  }

  public void draw(App app) {
    PImage tile = app.getSprite(this.color);
    app.image(tile, x*App.CELLSIZE, y*App.CELLSIZE+App.TOPBAR);
  }
}
