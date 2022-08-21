package ShapeUtil;

import javax.swing.*;
import java.awt.*;

public class DefineShape extends JPanel {
    public Color color;
    public boolean isFilled;
    public int positionX, positionY;
    public int width;
    public int height;

    public DefineShape(Color color, boolean isFilled, int positionX, int positionY, int width, int height) {

        this.color = color;
        this.isFilled = isFilled;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
    }
}