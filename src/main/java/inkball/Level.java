package inkball;

public class Level {
  private String layout;
  private int time;
  private int spawn_interval;
  private double score_increase_from_hole_capture_modifier;
  private double score_decrease_from_wrong_hole_modifier;
  private String[] balls;

  public Level(String layout, int time, int spawn_interval, double score_increase_from_hole_capture_modifier,
      double score_decrease_from_wrong_hole_modifier, String[] balls) {
        this.layout= layout;
        this.time= time;
        this.spawn_interval= spawn_interval;
        this.score_increase_from_hole_capture_modifier= score_increase_from_hole_capture_modifier;
        this.score_decrease_from_wrong_hole_modifier= score_decrease_from_wrong_hole_modifier;
        this.balls = balls;
        


  }
}
