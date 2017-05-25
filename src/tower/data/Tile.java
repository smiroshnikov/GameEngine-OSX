package tower.data;

import org.newdawn.slick.opengl.Texture;

/**
 * Created by smiroshn on 5/25/17.
 */
public class Tile {
    private float x, y, width, height;
    private Texture texture;

    public Tile(float x, float y, float width, float height, Texture texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
    }
}
