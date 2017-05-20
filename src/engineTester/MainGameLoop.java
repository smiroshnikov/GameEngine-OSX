package engineTester;

import org.lwjgl.opengl.Display;

import org.lwjgl.opengl.GL11;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;

public class MainGameLoop {

    public static void main(String[] args) {

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        DisplayManager.createDisplay();

        System.out.println("LWJGL Version :" + org.lwjgl.Sys.getVersion());
        System.out.println("OpenGL Version :" + GL11.glGetString(GL11.GL_VERSION));

        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, 0.5f, 0,
                -0.5f, -0.5f, 0,
                0.5f, -0.5f, 0,
                0.5f, 0.5f, 0f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2
        };

        RawModel model = loader.loadToVAO(vertices, indices);

        while (!Display.isCloseRequested()) {

            renderer.prepare();
            shader.start();

            // game logic
            renderer.render(model);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUP();
        DisplayManager.closeDisplay();

    }

}