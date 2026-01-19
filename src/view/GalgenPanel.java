package view;

import javax.swing.*;
import java.awt.*;

public class GalgenPanel extends JPanel {

    private int fehler = 0;

    public void setFehler(int f) {
        fehler = f;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Galgen
        g.drawLine(50, 250, 150, 250);
        g.drawLine(100, 250, 100, 50);
        g.drawLine(100, 50, 200, 50);
        g.drawLine(200, 50, 200, 80);

        // Figur
        if (fehler > 0) g.drawOval(180, 80, 40, 40);        // Kopf
        if (fehler > 1) g.drawLine(200,120,200,180);      // Körper
        if (fehler > 2) g.drawLine(200,140,170,160);      // Arm links
        if (fehler > 3) g.drawLine(200,140,230,160);      // Arm rechts
        if (fehler > 4) g.drawLine(200,180,170,220);      // Bein links
        if (fehler > 5) g.drawLine(200,180,230,220);      // Bein rechts
    }
}
