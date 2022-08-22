package Panel.Util;

import Frame.MyFrame;
import javax.swing.*;
import java.awt.*;

public class GeneratePanel {

    public static void generatePanel() {
        MyFrame.panelGenerate = new JPanel();
        MyFrame.panelGenerate.setBounds(0, 0, 160, 200);
        MyFrame.panelGenerate.setBackground(Color.lightGray);
        MyFrame.panelGenerate.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(173, 216, 230)));

        String[] stringOfNumbers = new String[26];
        for(int i = 0; i <= 25; i++) {
            stringOfNumbers[i] = String.valueOf(i);
        }

        MyFrame.amountOfGenerations = new JComboBox(stringOfNumbers);
        MyFrame.panelGenerate.add(MyFrame.amountOfGenerations);

        MyFrame.generateButton = new JButton("Generate");
        MyFrame.clearButton = new JButton("Clear");
    }
}
