package tower.data;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static tower.helpers.Artist.*;

/**
 * Created by smiroshn on 5/24/17.
 */
public class Boot {
    public Boot() {

        //Static
        BeginSession();


        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            //DONT REMOVE THIS LINE , OPENGL is fucked up on mac , this line clears buffer
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            DrawQuad(100, 100, 100, 100);
            DrawQuad(200, 200, 100, 100);

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
