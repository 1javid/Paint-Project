package Frame.Util;

import Frame.MyFrame;
import javax.swing.*;

public class MenuBar {

    public static void menuBar() {

        MyFrame.menuBar = new JMenuBar();
        MyFrame.fileMenu = new JMenu("File");
        MyFrame.openItem = new JMenuItem("Open");
        MyFrame.saveItem = new JMenuItem("Save");
        MyFrame.exitItem = new JMenuItem("Exit");
        MyFrame.fileMenu.add(MyFrame.openItem);
        MyFrame.fileMenu.add(MyFrame.saveItem);
        MyFrame.fileMenu.add(MyFrame.exitItem);
        MyFrame.menuBar.add(MyFrame.fileMenu);
    }
}
