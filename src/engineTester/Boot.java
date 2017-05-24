package engineTester;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * Created by smiroshn on 5/24/17.
 */
public class Boot {
    public Boot() {
        Display.setTitle("Understanding OpenGL...");
        try {
            Display.setDisplayMode(new DisplayMode(320, 200));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glMatrixMode(GL11.GL_PROJECTION); //?
        GL11.glLoadIdentity();//?
        GL11.glOrtho(0, 600, 400, 0, 1, -1); //Camera

        while (!Display.isCloseRequested()) {

            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex2f(10, 10);
            GL11.glVertex2f(100, 100);
            GL11.glEnd();

            Display.update();
            Display.sync(60);

        }

        Display.destroy();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
