package renderEngine;

import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import shaders.StaticShader;
import toolbox.Maths;

public class Renderer {

    /**
     * Prepares the screen ? Color?
     */
    public void prepare() {
        // TODO read about alpha channel ?
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glClearColor(128, 0, 128, 1);
    }

//    public void render(RawModel model) {
//
//        //Binding VAO that we want to use
//        GL30.glBindVertexArray(model.getVaoID());
//
//        // Activating attribute list for the VAO in which our data is stored , index 0
//        // Remember Loader line 31 - storeDataInAttributeList(0,positions); that our 0 position of attribute list
//        GL20.glEnableVertexAttribArray(0);
//
//        // OpenGL rendering , we are rendering triangular polygons ,where to start and vertex count in model
//        GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
//
//        // Disabling attribute list
//        GL20.glDisableVertexAttribArray(0);
//
//        // Un-binding VAO
//        GL30.glBindVertexArray(0);
//
//    }

    public void render(Entity entity, StaticShader shader) {

        TexturedModel model = entity.getModel();
        RawModel rawModel = model.getRawModel();

        //Binding VAO that we want to use
        GL30.glBindVertexArray(rawModel.getVaoID());

        // Activating attribute list for the VAO in which our data is stored , index 0
        // Remember Loader line 31 - storeDataInAttributeList(0,positions); that our 0 position of attribute list
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);

        Matrix4f transformationMatrix = Maths.createTansformationMatrix(entity.getPosition(),
                entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
        shader.loadTransformationMatrix(transformationMatrix);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getTextureID());

        // OpenGL rendering , we are rendering triangular polygons ,where to start and vertex count in model
        GL11.glDrawElements(GL11.GL_TRIANGLES, rawModel.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);

        // Disabling attribute list
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);

        // Un-binding VAO
        GL30.glBindVertexArray(0);

    }


}