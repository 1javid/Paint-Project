package FrameUtil;

import Frame.MyFrame;
import javax.swing.*;

public class ExitApp {

    public static void exitApp() {
        JPanel panel = new JPanel();
        if(MyFrame.flag == 0) {
            String[] warningOptions = {"Yes", "No"};

            int a = JOptionPane.showOptionDialog(panel, "Unsaved work will be lost. Are you sure you want to exit?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, warningOptions, warningOptions[1]);
            if(a == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }
}
