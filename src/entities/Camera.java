package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by smiroshn on 5/22/17.
 * Represents virtual camera
 */
public class Camera {

    private Vector3f position = new Vector3f(0, 0, 0);
    private float pitch;
    private float yaw;
    private float roll;
    private float step = 0.02f;

    public Camera() {
    }

    public void move() {

        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            position.z -= step;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            position.x += step;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            position.x -= step;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            position.z += step;

        }

    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
}

