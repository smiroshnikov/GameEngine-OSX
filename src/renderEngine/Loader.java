package renderEngine;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 *
 * @author Iidwuurliik
 *
 * This class loads 3d model into memory
 * by storing positional data about in a Vertex Array Object
 *
 */

public class Loader {

    // Memory management helpers  lists of all vbos and vaos
    private List<Integer> vaos = new ArrayList<Integer>();
    private List<Integer> vbos = new ArrayList<Integer>();


    public RawModel loadToVAO (float [] positions){
        int vaoID = createVAO();
        storeDataInAttributeList(0,positions);
        unbindVAO();

        // x,y,z every 3 values are considered a vertex
        return new RawModel(vaoID, positions.length/3);
    }

    public void cleanUP() {
        for (int vao : vaos){
            GL30.glDeleteVertexArrays(vao);
        }
        for (int vbo : vbos){
            GL15.glDeleteBuffers(vbo);
        }

    }

    /**
     *
     * @return ID of the created VAO
     */
    private int createVAO(){

        // creates  empty VertexArrayObject and returns ID
        int vaoID = GL30.glGenVertexArrays();
        vaos.add(vaoID);
        // activates VAO by binding it. What does binding means ? requires vaoID
        GL30.glBindVertexArray(vaoID);
        return vaoID ;
    }

    /**
     * Stores data in the VAO attribute list
     * @param attributeNumber - number of the attribute list in VAO
     * @param data - data itself (coordinated , colors , normals etc...)
     */
    private void storeDataInAttributeList(int attributeNumber, float [] data){
        int vboID = GL15.glGenBuffers(); // vertex buffer object Id is created here empty VBO
        vbos.add(vboID);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);// binding VBO  - TODO read !
        FloatBuffer buffer = storeDataInFloatBuffer(data);

        // specifying type of VBO - array buffer
        // providing data and specifying that data will be used as static meaning that OpenGL will know
        // that we do not want to edit the data once it is stored in VBO
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);

        // putting VBO into VAO attribute list
        GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0);

        // un-binding current VBO
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    /**
     * When finished using VAO ,
     * un-binds currently bound VAO
     */
    private void unbindVAO () {
        //TODO understand meaning of binding and un-binding
        GL30.glBindVertexArray(0); // 0 instead of ID
    }


    /**
     * Method converts float array of data into FloatBuffer
     * Data can only be stored in VBO as a FloatBuffer
     *
     * @param data
     * @return
     */
    private FloatBuffer storeDataInFloatBuffer (float[] data){
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data); // here buffer is expecting to be written to
        buffer.flip(); // preparing the buffer to be read from and not written to
        return buffer;		// here the buffer can be read from (after flip)
    }


}