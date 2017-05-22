package engineTester;

import entities.Entity;
import models.TexturedModel;
import org.lwjgl.opengl.Display;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

import static java.lang.Math.abs;

public class MainGameLoop {

    public static void main(String[] args) {

        DisplayManager.createDisplay();
        Loader loader = new Loader();


        System.out.println("LWJGL Version :" + org.lwjgl.Sys.getVersion());
        System.out.println("OpenGL Version :" + GL11.glGetString(GL11.GL_VERSION));

        StaticShader shader = new StaticShader();
        Renderer renderer = new Renderer(shader);


        // object coordinatesVBO
        float[] vertices = {
                -0.5f, 0.5f, 0,     //V0
                -0.5f, -0.5f, 0,    //V1
                0.5f, -0.5f, 0,     //V2
                0.5f, 0.5f, 0f      //V3
        };

        float[] textureCoordinates;

        int[] indices = {
                0, 1, 3,  //Top left triangle (V0,V1,V3)
                3, 1, 2   //Bottom right triangle (V3,V1,V2)
        };

        // texture coordinates VBO
        float[] textureCoords = {
                0, 0,   //V0
                0, 1,   //V1
                1, 1,   //V2
                1, 0    //V3

        };


        RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
        TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("myLogoBright")));
        Entity entity = new Entity(staticModel, new Vector3f(0, 0, -1), 0, 0, 0, 0.9f);

        while (!Display.isCloseRequested()) {
            // game logicRegion


            entity.increasePosition(0, 0, -0.001f);
            entity.increaseRotation(0, 1, 0);

            // game logicRegion
            renderer.prepare();
            shader.start();
            renderer.render(entity, shader);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUP();
        DisplayManager.closeDisplay();

    }

}