package inkball;

import processing.core.PConstants;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Tile {

  protected int x;
  protected int y;
  protected boolean is_covered;

  public Tile(int x, int y) {
    this.x = x;
    this.y = y;
    this.is_covered = false;
  }

  public void draw(App app) {
    if (this.is_covered == false) {
      PImage tile = app.getSprite("tile");
      app.image(tile, x * App.CELLSIZE, y * App.CELLSIZE + App.TOPBAR);
    }
  }

  public List<Tile> getAdjacentTiles(App app) {
    ArrayList<Tile> result = new ArrayList<>();
    if (x + 1 < app.getBoard()[y].length) {
      result.add(app.getBoard()[y][x + 1]);
    }
    if (y + 1 < app.getBoard().length && x + 1 < app.getBoard()[y].length) {
      result.add(app.getBoard()[y + 1][x + 1]);
    }
    if (y - 1 >= 0 && x + 1 < app.getBoard()[y].length) {
      result.add(app.getBoard()[y - 1][x + 1]);
    }
    if (y + 1 < app.getBoard().length) {
      result.add(app.getBoard()[y + 1][x]);
    }
    if (y - 1 >= 0) {
      result.add(app.getBoard()[y - 1][x]);
    }
    if (x - 1 >= 0) {
      result.add(app.getBoard()[y][x - 1]);
    }
    if (x - 1 >= 0 && y + 1 < app.getBoard().length) {
      result.add(app.getBoard()[y + 1][x - 1]);
    }
    if (x - 1 >= 0 && y - 1 >= 0) {
      result.add(app.getBoard()[y - 1][x - 1]);
    }
    return result;
  }
}
