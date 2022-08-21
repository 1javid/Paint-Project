package Shapes;
import ShapeUtil.DefineShape;
import java.awt.*;

public class Rectangle extends DefineShape implements Shape {

    public Rectangle(Color color, boolean isFilled, int positionX, int positionY, int width, int height) {
        super(color, isFilled, positionX, positionY, width, height);
    }

    @Override
    public void draw(Graphics g) {

        paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(color);

        if(isFilled)
            g2D.fillRect(positionX, positionY, width, height);
        else
            g2D.drawRect(positionX, positionY, width, height);
    }
}