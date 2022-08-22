package FrameUtil;

import Frame.MyFrame;
import Shapes.Shape;

public class ClearShapes {

    public static void generateShapes() {
        MyFrame.g = MyFrame.mainPanelAccess.drawingPanel.getGraphics();
        Shape.clear(MyFrame.g);
        MyFrame.amountOfGenerations.setSelectedIndex(0);
        MyFrame.generateButton.doClick();
        MyFrame.flag = 1;
    }
}
