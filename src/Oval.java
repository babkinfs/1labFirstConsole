import javax.swing.*;
import java.awt.*;

public class Oval extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setColor(Color.orange);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());

        GradientPaint gradient = new GradientPaint(
                getWidth() / 4, getHeight() / 4, Color.red,
                getWidth() * 3 / 4, getHeight() * 3 / 4, Color.orange);

        graphics2d.setPaint(gradient);
        graphics2d.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
    }
}
