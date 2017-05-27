package tower.data;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import static tower.helpers.Artist.*;

/**
 * Created by smiroshn on 5/24/17.
 */
public class Boot {
    public Boot() {

        //Static
        BeginSession();

        Texture t = QuickLoad("ground-stones.png");
        Texture t2 = QuickLoad("grey-road.png");
        Tile grass_tile = new Tile(0, 0, 64, 64, TileType.Grass);
        Tile road_tile = new Tile(0, 64, 64, 64, TileType.Road);


        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            //DON'T REMOVE THIS LINE , OPENGL is fucked up on mac , this line clears buffer
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);


            // START HERE
            DrawQuadTex(grass_tile.getTexture(), grass_tile.getX(), grass_tile.getY(), grass_tile.getWidth(), grass_tile.getHeight());
            DrawQuadTex(road_tile.getTexture(), road_tile.getX(), road_tile.getY(), road_tile.getWidth(), road_tile.getHeight());



            System.out.println("X:" + Mouse.getX() + "  " + "Y:" + Mouse.getY());

            Display.update();
            Display.sync(30);


        }

        Display.destroy();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
