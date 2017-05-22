package shaders;

import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by smiroshn on 5/20/17.
 */
public class StaticShader extends ShaderProgram {


    private static final String VERTEX_FILE = "/Users/smiroshn/IdeaProjects/GameEngine/src/shaders/vertexShader";

    private static final String FRAGMENT_FILE = "/Users/smiroshn/IdeaProjects/GameEngine/src/shaders/fragmentShader";

    private int location_transformationMatrix;
    private int location_projectionMatrix;

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    /**
     * This tiny method provides connection between shaders and the rest of the program
     */
    @Override
    protected void bindAttributes() {
        // position is used in vertex file , 0 means first  attribute list  in the VAO
        super.bindAttributes(0, "position");
        super.bindAttributes(1, "textureCoords");

    }

    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
    }

    public void loadTransformationMatrix(Matrix4f matrix) {
        super.loadMatrix(location_transformationMatrix, matrix);

    }

    public void loadProjectionMatrix(Matrix4f projection) {
        super.loadMatrix(location_projectionMatrix, projection);
    }


}
