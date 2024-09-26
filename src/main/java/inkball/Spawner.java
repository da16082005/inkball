package inkball;
import processing.core.PImage;

public class Spawner extends Tile  {

    public Spawner(int x, int y){
        super(x, y);
        this.is_covered= true;
    }
    public void draw(App app){
        PImage tile= app.getSprite("entrypoint");
        app.image(tile, x*App.CELLSIZE, y*App.CELLSIZE+App.TOPBAR);
    }

}
