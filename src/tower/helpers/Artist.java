package tower.helpers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * Created by smiroshn on 5/25/17.
 * Will handle openGL textures and resolution
 * will be used for drawing
 */
public class Artist {
    public static final int WIDTH = 640, HEIGHT = 480;

    public static void BeginSession() {
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

    }

    public static void DrawQuad(float x, float y, float width, float height) {

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x + width, y);
        GL11.glVertex2f(x + width, y + height);
        GL11.glVertex2f(x, y + height);
        GL11.glEnd();
    }

}
