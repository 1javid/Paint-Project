package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import FrameUtil.*;

import Frame.Util.MenuBar;

import Panel.Util.GeneratePanel;
import Panel.Util.BlankPanel;
import Panel.Util.MainPanel;

import ShapeUtil.RandomShapeGenerator;
import Shapes.Shape;

public class MyFrame extends JFrame implements ActionListener {

    public static JPanel panelGenerate, panelBlank;
    public static JButton generateButton, clearButton;
    public static JComboBox amountOfGenerations;
    public static JMenuBar menuBar;
    public static JMenu fileMenu;
    public static JMenuItem openItem, saveItem, exitItem;
    public static RandomShapeGenerator mainPanelAccess;
    public static Graphics g;
    public static Shape shape;
    public static List<Shape> shapeList;
    public static ImageIcon image;
    public static int flag = 1;

    public MyFrame() {

        //----------------Menu Bar----------------

        MenuBar.menuBar();
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        this.setJMenuBar(menuBar);

        //----------------Generate Panel----------------

        GeneratePanel.generatePanel();
        generateButton.addActionListener(this);
        clearButton.addActionListener(this);
        panelGenerate.add(generateButton);
        panelGenerate.add(clearButton);
        this.add(panelGenerate);

        //----------------Blank Panel----------------

        BlankPanel.blankPanel();
        this.add(panelBlank);

        //----------------Main Panel----------------

        MainPanel.mainPanel();
        this.add(mainPanelAccess.drawingPanel);

        //----------------JFrame----------------

        this.setTitle("Little Paint Project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(image.getImage());
        this.setLayout(null);
        this.setSize(900, 800);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == openItem) {
            OpenFile.openFile();
        }
        else if(e.getSource() == saveItem) {
            SaveFile.saveFile();
        }
        else if(e.getSource() == generateButton) {
            GenerateShapes.generateShapes();
        }
        else if(e.getSource() == clearButton) {
            ClearShapes.generateShapes();
        }
        else {
            ExitApp.exitApp();
        }
    }

    public static void smoothGeneration() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}