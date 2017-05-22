package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {

    private static final int WIDTH = 320;
    private static final int HEIGHT = 200;
    private static final int FPS_CAP = 120;

    public static void createDisplay() {

        ContextAttribs attribs = new ContextAttribs(3, 2).withProfileCore(true).withForwardCompatible(true); // OpenGL version 3.2
        // line below works on windows and line above is working on mac ? Why , no idea but after 5 hours of goggling I don't give a fuck
        //attribs.withForwardCompatible(true).withProfileCore(true);
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("Game Engine 1.0");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        GL11.glViewport(0, 0, WIDTH, HEIGHT); //OpenGL use whole of the display
    }

    public static void updateDisplay() {
        Display.sync(FPS_CAP);
        Display.update();
    }

    public static void closeDisplay() {
        Display.destroy();
    }
}

//VAO - Vertex Array Objects  - modern way of storing and redering models in OpenGl
//VAO contain Data , have "slots" , in each slot - attribute lists
//VAO slots can contain "vertex positions"  or "vertex colors " or "normal vectors" or textures or anything i want (positions , colors , normals
//VBO - Vertex Buffer Objects

// VAO have ID , and contain VBO as parameters
// VBO contain triangular polygons coordinates of each polygon of a 3D object
