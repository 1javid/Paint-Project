package ShapeUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import Panel.MyPanel;
import Shapes.Shape;

public class RandomShapeGenerator {

    public static MyPanel drawingPanel;
    public static Random randomGen = new Random();
    public static int randomX, randomY, randomW, randomH;


    public RandomShapeGenerator() {
        drawingPanel = new MyPanel();
    }

    public static void randomShapeValues() {

        int MAX_SHAPE_SIZE = 150;
        int MIN_SHAPE_SIZE = 50;

        randomX = randomGen.nextInt(drawingPanel.getWidth() - MAX_SHAPE_SIZE);
        randomY = randomGen.nextInt(drawingPanel.getHeight() - MAX_SHAPE_SIZE);
        randomW = randomGen.nextInt(MAX_SHAPE_SIZE - MIN_SHAPE_SIZE) + MIN_SHAPE_SIZE;
        randomH = randomGen.nextInt(MAX_SHAPE_SIZE - MIN_SHAPE_SIZE) + MIN_SHAPE_SIZE;
    }

    public static Shape produceRandomShape() {

        randomShapeValues();
        return ShapeFactory.createShape(ShapeType.pickRandomShapeType(randomGen));
    }
    public static Shape produceRandomShape(String s) {

        randomShapeValues();
        if(s.contains("Rectangle"))
            return  ShapeFactory.createShape("Rectangle");
        if(s.contains("Square"))
            return  ShapeFactory.createShape("Square");
        if(s.contains("Ellipse"))
            return  ShapeFactory.createShape("Ellipse");

        return ShapeFactory.createShape("Circle");
    }

    public static Color pickRandomColor() {

        ArrayList<Color> colorArray = new ArrayList<>();

        int i = 0;
        while(i++ <= 100) {
            int j = 0;
            while(j++ <= 100) {
                int k = 0;
                while(k++ <= 100) {
                    colorArray.add(new Color(i, j, k));
                }
            }
        }

        int randomColor = new Random().nextInt(colorArray.size());

        return colorArray.get(randomColor);
    }

    public static boolean pickRandomIsFilled () {

        final boolean[] isFilledArray = {true, false};
        int randomIsFilled = new Random().nextInt(isFilledArray.length);

        return isFilledArray[randomIsFilled];
    }
}
