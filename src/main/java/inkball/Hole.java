package inkball;

import processing.core.PImage;

public class Hole extends Tile {
  private String color;
  private double score_decrease_from_wrong_hole_modifier;
  private double score_increase_from_hole_capture_modifier;
  private int score_decrease_from_wrong_hole;
  private int score_increase_from_hole_capture;

  public Hole(int x, int y, String color, double score_increase_from_hole_capture_modifier,
      double score_decrease_from_wrong_hole_modifier, int score_decrease_from_wrong_hole,
      int score_increase_from_hole_capture, Tile top_right, Tile bot_left, Tile bot_right) {
    super(x, y);
    this.is_covered = true;
    top_right.is_covered = true;
    bot_left.is_covered = true;
    bot_right.is_covered = true;
    this.color = color;
    this.score_decrease_from_wrong_hole_modifier = score_decrease_from_wrong_hole_modifier;
    this.score_increase_from_hole_capture_modifier = score_increase_from_hole_capture_modifier;
    this.score_decrease_from_wrong_hole = score_decrease_from_wrong_hole;
    this.score_increase_from_hole_capture = score_increase_from_hole_capture;
  }

  public void draw(App app) {
    PImage tile = app.getSprite(this.color);
    app.image(tile, x * App.CELLSIZE, y * App.CELLSIZE + App.TOPBAR);
  }
}
