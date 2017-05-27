package tower.data;

/**
 * My tile architecture  definition , new tiles will be added here
 * Created by smiroshn on 5/27/17.
 */
public enum TileType {
    Grass("grass.png", true), Dirt("dirt.png", false), SandRune("sandRune.png", false), Chaos("Chaos.png", false), Water("water.png", false);
    String textureName;
    boolean buildable; //if can be build on !

    TileType(String textureName, boolean buildable) {
        this.textureName = textureName;
        this.buildable = buildable;
    }
}
