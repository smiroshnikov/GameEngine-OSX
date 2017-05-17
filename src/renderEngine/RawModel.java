package renderEngine;


/**
 *
 * @author Iidwuurliik
 * This class represents a 3d model stored in memory
 *
 */
public class RawModel {
    private int vaoID; // ID required to pull relevant Vertex Array Model from memory
    private int vertexCount;

    public RawModel(int vaoID, int vertexCount){
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;
    }

    public int getVaoID() {
        return vaoID;
    }

    public int getVertexCount() {
        return vertexCount;
    }
}