package FrameUtil;

import Frame.MyFrame;
import ShapeUtil.ShapeService;

public class SaveFile {
    public static void saveFile() {
        MyFrame.flag = 1;
        new ShapeService().saveShapes(MyFrame.shapeList);
    }
}
