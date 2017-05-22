package engineTester;

/**
 * Created by smiroshn on 5/22/17.
 */
public class tester {
    public static void main(String[] args) {
        float position = 0f;
        while (true) {
            position += 0.2f;
            System.out.println("forward -> " + position);
            if (position > 1.49f) {
                while (position > -1.2f) {
                    position -= 0.02f;
                    System.out.println("<- backward" + position);
                }
            }
        }
    }
}
