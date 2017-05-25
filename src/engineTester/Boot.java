package engineTester;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import renderEngine.DisplayManager;

/**
 * Created by smiroshn on 5/24/17.
 */
public class Boot {
    public Boot() {
        Display.setTitle("Understanding OpenGL...");
        try {
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glMatrixMode(GL11.GL_PROJECTION); //?
        GL11.glLoadIdentity();//?
        GL11.glOrtho(0, 600, 400, 0, 1, -1); //Camera
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); //very important to clear the buffer

            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex2f(10, 10);
            GL11.glVertex2f(100, 100);
            GL11.glEnd();


            Display.update();
            Display.sync(30);


        }

        Display.destroy();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
