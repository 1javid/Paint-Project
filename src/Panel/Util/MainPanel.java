package Panel.Util;

import Frame.MyFrame;
import ShapeUtil.RandomShapeGenerator;

public class MainPanel {

    public static void mainPanel() {
        MyFrame.mainPanelAccess = new RandomShapeGenerator();
    }
}
