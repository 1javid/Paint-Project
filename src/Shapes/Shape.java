package Shapes;
import java.awt.*;

public interface Shape{
    void draw(Graphics g);
    static void clear(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.clearRect(0, 0, 900, 900);
    }
}