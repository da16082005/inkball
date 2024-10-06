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
          } else if (ch == '1') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall1");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall1");
            }
          } else if (ch == '2') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall2");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall2");
            }
          } else if (ch == '3') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall3");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall3");
            }
          } else if (ch == '4') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall4");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall4");
            }
          } else if (ch == 'S') {
            board[row][i] = new Spawner(i, row);
          } else if (ch == 'H') {
            if (line.charAt(i + 1) == '0') {
              board[row][i] = new Hole(i, row, "hole0", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);
            } else if (line.charAt(i + 1) == '1') {
              board[row][i] = new Hole(i, row, "hole1", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);

            } else if (line.charAt(i + 1) == '2') {
              board[row][i] = new Hole(i, row, "hole2", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);

            } else if (line.charAt(i + 1) == '3') {
              board[row][i] = new Hole(i, row, "hole3", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);
            } else if (line.charAt(i + 1) == '4') {
              board[row][i] = new Hole(i, row, "hole4", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);
            }
          } else if (ch == 'B') {
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

  // load from file txt to Tile[][]
  public Ball[] loadBalls(App app, String filePath) {
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
          } else if (ch == '1') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall1");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall1");
            }
          } else if (ch == '2') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall2");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall2");
            }
          } else if (ch == '3') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall3");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall3");
            }
          } else if (ch == '4') {
            if (i == 0) {
              board[row][i] = new Wall(i, row, "wall4");
            } else if (line.charAt(i - 1) != 'H' && line.charAt(i - 1) != 'B') {
              board[row][i] = new Wall(i, row, "wall4");
            }
          } else if (ch == 'S') {
            board[row][i] = new Spawner(i, row);
          } else if (ch == 'H') {
            if (line.charAt(i + 1) == '0') {
              board[row][i] = new Hole(i, row, "hole0", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);
            } else if (line.charAt(i + 1) == '1') {
              board[row][i] = new Hole(i, row, "hole1", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);

            } else if (line.charAt(i + 1) == '2') {
              board[row][i] = new Hole(i, row, "hole2", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);

            } else if (line.charAt(i + 1) == '3') {
              board[row][i] = new Hole(i, row, "hole3", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);
            } else if (line.charAt(i + 1) == '4') {
              board[row][i] = new Hole(i, row, "hole4", 0, 0, 0, 0, board[row + 1][i], board[row][i + 1],
                  board[row + 1][i + 1]);
            }
          } else if (ch == 'B') {
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
