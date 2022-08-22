package FrameUtil;

import Frame.MyFrame;
import Shapes.Shape;
import java.util.ArrayList;

public class GenerateShapes {

    public static void generateShapes() {
        MyFrame.flag = 0;

        String generateNum = String.valueOf(MyFrame.amountOfGenerations.getSelectedItem());
        MyFrame.shapeList = new ArrayList<>();

        for(int i = 1; i <= Integer.parseInt(generateNum); i++) {
            MyFrame.g = MyFrame.mainPanelAccess.drawingPanel.getGraphics();
            MyFrame.shape = (Shape) MyFrame.mainPanelAccess.produceRandomShape();
            MyFrame.shape.draw(MyFrame.g);

            MyFrame.shapeList.add(MyFrame.shape);

            MyFrame.smoothGeneration();
        }
    }
}
