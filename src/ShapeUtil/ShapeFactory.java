package ShapeUtil;

import Shapes.Circle;
import Shapes.Ellipse;
import Shapes.Rectangle;
import Shapes.Square;
import Shapes.Shape;
import java.awt.*;

public class ShapeFactory {

    //use getShape method to get object of type shape
    public static Shape getShape(String shapeType, Color color, boolean isFilled, int randomX, int randomY, int randomW, int randomH){

        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle(color, isFilled, randomX, randomY, randomW, randomH);

        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square(color, isFilled, randomX, randomY, randomW, randomH);

        } else if(shapeType.equalsIgnoreCase("ELLIPSE")){
            return new Ellipse(color, isFilled, randomX, randomY, randomW, randomH);

        } else if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle(color, isFilled, randomX, randomY, randomW, randomH);
        }

        return null;
    }

    public static Shape createShape(String shapeName) {
        return ShapeFactory.getShape(
                shapeName,
                RandomShapeGenerator.pickRandomColor(),
                RandomShapeGenerator.pickRandomIsFilled(),
                RandomShapeGenerator.randomX, RandomShapeGenerator.randomY,
                RandomShapeGenerator.randomW, RandomShapeGenerator.randomH
        );
    }
}