import java.applet.Applet;
import java.awt.*;

/*
<applet code="S2b.class" width="400" height="300">
</applet>
*/

public class S2b extends Applet implements Runnable {

    int step = 0;

    public void start() {
        for(int i = 0; i < 4; i++) {
            new Thread(this).start();
        }
    }

    public void run() {
        try {
            Thread.sleep(800);
            step++;
            repaint();
        } catch(Exception e) {}
    }

    public void paint(Graphics g) {

        // Saffron
        if(step >= 1) {
            g.setColor(Color.ORANGE);
            g.fillRect(100, 50, 200, 40);
        }

        // White
        if(step >= 2) {
            g.setColor(Color.WHITE);
            g.fillRect(100, 90, 200, 40);
        }

        // Green
        if(step >= 3) {
            g.setColor(Color.GREEN);
            g.fillRect(100, 130, 200, 40);
        }

        // Ashoka Chakra
        if(step >= 4) {
            g.setColor(Color.BLUE);

            int centerX = 200;
            int centerY = 110;
            int radius = 15;

            // Outer circle
            g.drawOval(centerX - radius, centerY - radius, 30, 30);

            // Inner small circle
            g.drawOval(centerX - 3, centerY - 3, 6, 6);

            // 24 spokes
            for(int i = 0; i < 24; i++) {
                double angle = Math.toRadians(i * 15);
                int x = (int)(centerX + radius * Math.cos(angle));
                int y = (int)(centerY + radius * Math.sin(angle));
                g.drawLine(centerX, centerY, x, y);
            }
        }
    }
}
