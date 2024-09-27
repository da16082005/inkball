package inkball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Level {
  private String layout;
  private int time;
  private int spawn_interval;
  private double score_increase_from_hole_capture_modifier;
  private double score_decrease_from_wrong_hole_modifier;
  private String[] balls;

  public Level(String layout, int time, int spawn_interval, double score_increase_from_hole_capture_modifier,
      double score_decrease_from_wrong_hole_modifier, String[] balls) {
    this.layout = layout;
    this.time = time;
    this.spawn_interval = spawn_interval;
    this.score_increase_from_hole_capture_modifier = score_increase_from_hole_capture_modifier;
    this.score_decrease_from_wrong_hole_modifier = score_decrease_from_wrong_hole_modifier;
    this.balls = balls;
  }

  public String getLayout() {
    return layout;
  }

  // load from file txt to Tile[][]
  public Tile[][] loadLayout(App app, String filePath) {
    // create attributes for data storage, eg board
    Tile[][] board = new Tile[(App.HEIGHT - App.TOPBAR) / App.CELLSIZE][App.WIDTH / App.CELLSIZE];

    for (int i = 0; i < board.length; i++) {
      for (int i2 = 0; i2 < board[i].length; i2++) {
        board[i][i2] = new Tile(i2, i);
      }
    }

    // read from filepath to String[][]
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      int row = 0;
      String line = br.readLine();
      while (line != null) {
        for (int i = 0; i < line.length(); i++) {
          char ch = line.charAt(i);
          if (ch == 'X') {
            board[row][i] = new Wall(i, row, "wall0");
          }
        }
        line = br.readLine();
        row += 1;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return board;
  }
}
