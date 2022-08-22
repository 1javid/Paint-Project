package Panel.Util;

import Frame.MyFrame;
import javax.swing.*;
import java.awt.*;

public class BlankPanel {

    public static void blankPanel() {
        MyFrame.image = new ImageIcon("icon.jpg");

        MyFrame.panelBlank = new JPanel();
        MyFrame.panelBlank.setBounds(0, 140, 160, 600);
        MyFrame.panelBlank.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));
    }
}
