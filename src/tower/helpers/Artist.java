package tower.helpers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;


import static org.lwjgl.opengl.GL11.*;

/**
 * Created by smiroshn on 5/25/17.
 * Will handle openGL textures and resolution
 * will be used for drawing
 */
public class Artist {

    private static final int WIDTH = 1280, HEIGHT = 960; //20 x 15 - 64 bit tiles

    public static void BeginSession() {
        Display.setTitle("Understanding OpenGL...");
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        glMatrixMode(GL_PROJECTION); //?
        glLoadIdentity();//?
        glOrtho(0, 600, 400, 0, 1, -1); //Camera
        glMatrixMode(GL_MODELVIEW);
        glEnableClientState(GL_TEXTURE_2D);

    }

    public static void DrawQuad(float x, float y, float width, float height) {

        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
        glEnd();
    }

    public static void DrawQuadTex(Texture texture, float x, float y, float width, float height) {
        // Binding texture to openGL
        texture.bind();
        // 
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        //--texture quad
        glTexCoord2d(0, 0);
        glVertex2f(0, 0);

        glTexCoord2d(1, 0);
        glVertex2f(width, 0);

        glTexCoord2d(1, 1);
        glVertex2f(width, height);

        glTexCoord2d(0, 1);
        glVertex2f(0, height);
        //--texture quad 

    }

}
