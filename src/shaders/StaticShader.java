package shaders;

/**
 * Created by smiroshn on 5/20/17.
 */
public class StaticShader extends ShaderProgram {


    private static final String VERTEX_FILE = "/Users/smiroshn/IdeaProjects/GameEngine/src/shaders/vertexShader";

    private static final String FRAGMENT_FILE = "/Users/smiroshn/IdeaProjects/GameEngine/src/shaders/fragmentShader";

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
}
