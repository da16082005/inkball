package inkball;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import java.io.*;
import java.util.*;

public class App extends PApplet {

  public static final int CELLSIZE = 32; // 8;
  public static final int CELLHEIGHT = 32;

  public static final int CELLAVG = 32;
  public static final int TOPBAR = 64;
  public static int WIDTH = 576; // CELLSIZE*BOARD_WIDTH;
  public static int HEIGHT = 640; // BOARD_HEIGHT*CELLSIZE+TOPBAR;
  public static final int BOARD_WIDTH = WIDTH / CELLSIZE;
  public static final int BOARD_HEIGHT = 20;

  public static final int INITIAL_PARACHUTES = 1;

  public static final int FPS = 30;

  public String configPath;

  public static Random random = new Random();

  private Tile[][] board;
  private HashMap<String, PImage> sprites = new HashMap<>();
  private Config config;

  public App() {
    this.configPath = "config.json";
  }

  /*
   * Initialise the setting of the window size.
   */
  @Override
  public void settings() {
    size(WIDTH, HEIGHT);
  }

  /**
   * Load all resources such as images. Initialise the elements such as the player
   * and map elements.
   */
  public Tile[][] getBoard() {
    return this.board;
  }

  public PImage getSprite(String s) {
    PImage result = sprites.get(s);
    if (result == null) {
      try {
        result = loadImage(
            URLDecoder.decode(this.getClass().getResource(s + ".png").getPath(), StandardCharsets.UTF_8.name()));
      } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
      }
      ;
      sprites.put(s, result);
    }
    return result;
  }
  /*
   * @Override
   * public void loadJSONObject(String configPath){
   * ObjectMapper objectMapper = new ObjectMapper();
   * try{
   * Config config = objectMapper.readValue(new File(configPath),Config.class);
   * 
   * }catch (IOException e){
   * e.printStackTrace();
   * }
   * 
   * 
   * }
   */

  @Override
  public void setup() {
    frameRate(FPS);

    JSONObject loadedConfig = loadJSONObject(configPath);
    this.config = new Config(loadedConfig);

    // the image is loaded from relative path: "src/main/resources/inkball/..."
    String filenames[] = new String[] {
        "ball0", "ball1", "ball2", "ball3", "ball4", "entrypoint", "hole0", "hole1", "hole2", "hole3", "hole4",
        "inkball_spritesheet", "tile", "wall0", "wall1", "wall2", "wall3", "wall4",
    };

    for (int i = 0; i < filenames.length; i++) {
      getSprite(filenames[i]);
    }

    // create attributes for data storage, eg board
    System.out.println(config.levels[0].getLayout());
    this.board = config.levels[0].loadLayout(this, config.levels[0].getLayout());
  }

  /**
   * Receive key pressed signal from the keyboard.
   */
  @Override
  public void keyPressed(KeyEvent event) {

  }

  /**
   * Receive key released signal from the keyboard.
   */
  @Override
  public void keyReleased() {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    // create a new player-drawn line object
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    // add line segments to player-drawn line object if left mouse button is held

    // remove player-drawn line object if right mouse button is held
    // and mouse position collides with the line
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  /**
   * Draw all elements in the game by current frame.
   */
  @Override
  public void draw() {
    // display Board for current level:
    background(200, 200, 200);
    for (int i = 0; i < this.board.length; i++) {
      for (int i2 = 0; i2 < this.board[i].length; i2++) {
        this.board[i][i2].draw(this);
      }
    }

    // display score

    // display game end message
  }

  public static void main(String[] args) {
    PApplet.main("inkball.App");
  }

}
