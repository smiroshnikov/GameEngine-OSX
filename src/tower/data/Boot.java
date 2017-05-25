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

        Texture t = loadTexture("/Users/smiroshn/IdeaProjects/GameEngine/src/tower/res/grass-green.png", "PNG");
        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            //DON'T REMOVE THIS LINE , OPENGL is fucked up on mac , this line clears buffer
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);


            // START HERE
            DrawQuadTex(t, 0, 0, 64, 64);


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
