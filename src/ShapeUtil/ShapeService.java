package ShapeUtil;

import Shapes.Shape;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class ShapeService {

    public void saveShapes(List<Shape> shapes) {

        JPanel myPanel = new JPanel();
        String[] warningOptions = {"Yes", "No"};

        JFileChooser getFile = new JFileChooser();
        File selFile1;
        BufferedWriter myWriter;

        try {
            getFile.setCurrentDirectory(new File(System.getProperty("user.home")));
            int retrieval = getFile.showSaveDialog(null);

            if (retrieval == JFileChooser.APPROVE_OPTION) {

                selFile1 = getFile.getSelectedFile();

                //Creates and writes shapes to a new file
                if (!selFile1.exists()) {

                    selFile1.createNewFile();
                    myWriter = new BufferedWriter(new FileWriter(selFile1));

                    try {
                        for (Shape shape : shapes) {
                            myWriter.write(shape + "\n");
                        }
                    } catch (NullPointerException e) {

                    }
                    myWriter.close();
                } else {

                    //If file exists and user tries to save to the same file, warning pops up
                    int a = JOptionPane.showOptionDialog(myPanel, "This file already exists. Would you like to save to the existing file?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, warningOptions, warningOptions[1]);
                    try {

                        //If "Yes", then clear the file and write new shapes to it
                        //If "No, do nothing
                        if (a == JOptionPane.YES_OPTION) {

                            PrintWriter writer = new PrintWriter(selFile1);
                            writer.flush();
                            writer.close();
                            myWriter = new BufferedWriter(new FileWriter(selFile1));

                            for (Shape shape : shapes) {
                                myWriter.write(shape + "\n");
                            }
                            myWriter.close();
                        }
                    } catch (NullPointerException e) {

                    }
                }
            }
        } catch (IOException e) {

            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }

    public List<String> readShapes() {

        JFileChooser getFile = new JFileChooser();
        File selFile1;
        BufferedReader myReader;
        List<String> returnShapes = new ArrayList<>();

        try {
            getFile.setCurrentDirectory(new File(System.getProperty("user.home")));
            int retrieval = getFile.showOpenDialog(null);
            if (retrieval == JFileChooser.APPROVE_OPTION) {

                selFile1 = getFile.getSelectedFile();
                myReader = new BufferedReader(new FileReader(selFile1));
                List<Character> temp = new ArrayList<>();

                int ch;
                while((ch = myReader.read()) != -1) {
                    if((char) ch == '\n') {
                        char[] readCharacters = new char[temp.size()];

                        for(int i = 0; i < readCharacters.length; i++) {
                            readCharacters[i] = temp.get(i);
                        }
                        String str = String.valueOf(readCharacters);
                        returnShapes.add(str);
                        temp.clear();
                    }
                    temp.add((char) ch);
                }
            }
        } catch (IOException e) {

            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
        return returnShapes;
    }
}