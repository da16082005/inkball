package inkball;

import java.util.HashMap;

import processing.data.JSONArray;
import processing.data.JSONObject;

public class Config {
  private Level[] levels;
  public HashMap<String, Integer> score_increase_from_hole_capture = new HashMap<>();
  public HashMap<String, Integer> score_decrease_from_wrong_hole = new HashMap<>();

  public Config(JSONObject config) {
    // parse levels
    JSONArray loaded_levels = config.getJSONArray("levels");

    // parse score_increase_from_hole_capture
    JSONObject loaded_score_increase = config.getJSONObject("score_increase_from_hole_capture");
    for (Object key : loaded_score_increase.keys()) {
      String keyString = key.toString();
      Integer value = loaded_score_increase.getInt(keyString);
      score_increase_from_hole_capture.put(keyString, value);
    }

    // parse score_decrease_from_wrong_hole
    JSONObject loaded_score_decrease = config.getJSONObject("score_decrease_from_wrong_hole");
    for (Object key : loaded_score_decrease.keys()) {
      String keyString = key.toString();
      Integer value = loaded_score_increase.getInt(keyString);
      score_decrease_from_wrong_hole.put(keyString, value);
    }
  }
}
