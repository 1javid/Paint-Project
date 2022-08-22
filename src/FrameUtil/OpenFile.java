package FrameUtil;

import Frame.MyFrame;
import ShapeUtil.ShapeService;
import Shapes.Shape;
import java.util.List;

public class OpenFile {

    public static void openFile() {

        MyFrame.flag = 1;
        MyFrame.g = MyFrame.mainPanelAccess.drawingPanel.getGraphics();
        List<String> fileShapes = new ShapeService().readShapes();

        for (String fileShape : fileShapes) {
            Shape x = MyFrame.mainPanelAccess.produceRandomShape(fileShape);
            x.draw(MyFrame.g);
            MyFrame.smoothGeneration();
        }
    }
}
