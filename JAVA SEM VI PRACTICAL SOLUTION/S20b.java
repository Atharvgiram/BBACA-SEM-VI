import java.applet.Applet;
import java.awt.*;

/*
<applet code="S20b.class" width="400" height="400">
</applet>
*/

public class S20b extends Applet implements Runnable {

    int step = 0;

    public void start() {
        new Thread(this).start();
    }

    public void run() {
        while(step <= 4) {
            step++;
            repaint();
            try { Thread.sleep(1000); } catch(Exception e) {}
        }
    }

    public void paint(Graphics g) {

        // Base
        if(step >= 1) {
            g.setColor(Color.GRAY);
            g.fillRect(120, 250, 160, 80);
        }

        // Pillars
        if(step >= 2) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(140, 200, 30, 50);
            g.fillRect(230, 200, 30, 50);
        }

        // Roof
        if(step >= 3) {
            g.setColor(Color.RED);
            int x[] = {100, 200, 300};
            int y[] = {200, 150, 200};
            g.fillPolygon(x, y, 3);
        }

        // Top Dome
        if(step >= 4) {
            g.setColor(Color.ORANGE);
            g.fillOval(180, 120, 40, 40);
        }
    }
}
