package inkball;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class Config {
    private Level[] levels;
    private HashMap<String, Integer> score_increase_from_hole_capture;
    private HashMap<String, Integer> score_decrease_from_wrong_hole;

    public Config() {
        
    }


}
