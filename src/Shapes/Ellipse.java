package Shapes;
import ShapeUtil.DefineShape;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends DefineShape implements Shape {

    public Ellipse(Color color, boolean isFilled, int positionX, int positionY, int width, int height) {
        super(color, isFilled, positionX, positionY, width, height);
    }

    @Override
    public void draw(Graphics g) {

        paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(color);

        if(isFilled)
            g2D.fill(new Ellipse2D.Double(positionX, positionY, width, height));
        else
            g2D.draw(new Ellipse2D.Double(positionX, positionY, width, height));
    }
}