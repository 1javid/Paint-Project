package ShapeUtil;
import java.util.Random;

public enum ShapeType {
    ;

    public static String pickRandomShapeType(Random randomGen) {
        final String[] shapeArray = {"Rectangle", "Square", "Ellipse", "Circle"};
        int randomShape = randomGen.nextInt(shapeArray.length);

        return shapeArray[randomShape];
    }
}