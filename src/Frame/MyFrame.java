package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import ShapeUtil.RandomShapeGenerator;
import ShapeUtil.ShapeService;
import Shapes.Shape;

public class MyFrame extends JFrame implements ActionListener {

    JPanel panelGenerate, panelBlank;
    JButton generateButton, clearButton;
    JComboBox amountOfGenerations;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem, saveItem, exitItem;
    RandomShapeGenerator mainPanelAccess;
    Graphics g;
    Shape shape;
    List<Shape> shapeList;
    int flag = 1;

    public MyFrame() {

        //----------------Menu Bar----------------

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        //----------------Generate Panel----------------

        panelGenerate = new JPanel();
        panelGenerate.setBounds(0, 0, 160, 200);
        panelGenerate.setBackground(Color.lightGray);
        panelGenerate.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(173, 216, 230)));

        String[] stringOfNumbers = new String[26];
        for(int i = 0; i <= 25; i++) {
            stringOfNumbers[i] = String.valueOf(i);
        }

        amountOfGenerations = new JComboBox(stringOfNumbers);
        panelGenerate.add(amountOfGenerations);

        generateButton = new JButton("Generate");
        generateButton.addActionListener(this);


        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        panelGenerate.add(generateButton);
        panelGenerate.add(clearButton);

        //----------------Blank Panel----------------

        ImageIcon image = new ImageIcon("icon.jpg");

        panelBlank = new JPanel();
        panelBlank.setBounds(0, 140, 160, 600);
        panelBlank.setBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 2));

        //----------------Main Panel----------------

        mainPanelAccess = new RandomShapeGenerator();
        this.add(mainPanelAccess.drawingPanel);

        //----------------JFrame----------------

        this.setJMenuBar(menuBar);
        this.add(panelGenerate);
        this.add(panelBlank);
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

        //----------------Opening/Reading a File----------------

        if(e.getSource() == openItem) {

            flag = 1;
            g = mainPanelAccess.drawingPanel.getGraphics();
            List<String> fileShapes = new ShapeService().readShapes();

            for (String fileShape : fileShapes) {
                Shape x = (Shape) mainPanelAccess.produceRandomShape(fileShape);
                x.draw(g);
                smoothGeneration();
            }
        }

        //----------------Saving/Writing a File----------------

        else if(e.getSource() == saveItem) {
            flag = 1;
            new ShapeService().saveShapes(shapeList);
        }

        //----------------Generating Shapes----------------

        else if(e.getSource() == generateButton) {

            flag = 0;

            String generateNum = String.valueOf(amountOfGenerations.getSelectedItem());
            shapeList = new ArrayList<>();

            for(int i = 1; i <= Integer.parseInt(generateNum); i++) {
                g = mainPanelAccess.drawingPanel.getGraphics();
                shape = (Shape) mainPanelAccess.produceRandomShape();
                shape.draw(g);

                shapeList.add(shape);

                smoothGeneration();
            }
        }

        //----------------Clearing Shapes----------------

        else if(e.getSource() == clearButton) {
            g = mainPanelAccess.drawingPanel.getGraphics();
            Shape.clear(g);
            amountOfGenerations.setSelectedIndex(0);
            generateButton.doClick();
            flag = 1;
        }

        //----------------Exiting App----------------

        else {
            JPanel panel = new JPanel();
            if(flag == 0) {
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

    public void smoothGeneration() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}