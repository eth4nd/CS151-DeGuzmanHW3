package hw3;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Bars extends JComponent{

    private int redValue;
    private int greenValue;
    private int blueValue;

    public Bars(int redValue, int greenValue, int blueValue)
    {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public void updateValues(int redValue, int greenValue, int blueValue)
    {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double redRect = new Rectangle2D.Double(10, 0, 20, redValue);
        g2.setColor(Color.red);
        g2.fill(redRect);
        Rectangle2D.Double greenRect = new Rectangle2D.Double(60, 0, 20, greenValue);
        g2.setColor(Color.green);
        g2.fill(greenRect);
        Rectangle2D.Double blueRect = new Rectangle2D.Double(100, 0, 20, blueValue);
        g2.setColor(Color.blue);
        g2.fill(blueRect);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
}