import java.applet.Applet;
import java.awt.*;

/*
<applet code="S5b.class" width="300" height="350">
</applet>
*/

public class S5b extends Applet implements Runnable {

    int state = 0;   // 0-Red, 1-Yellow, 2-Green

    public void start() {
        new Thread(this).start();
    }

    public void run() {
        while(true) {
            state = (state + 1) % 3;
            repaint();
            try {
                Thread.sleep(1000);
            } catch(Exception e) {}
        }
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(100, 40, 80, 220);

        g.setColor(state == 0 ? Color.RED : Color.GRAY);
        g.fillOval(115, 60, 50, 50);

        g.setColor(state == 1 ? Color.YELLOW : Color.GRAY);
        g.fillOval(115, 130, 50, 50);

        g.setColor(state == 2 ? Color.GREEN : Color.GRAY);
        g.fillOval(115, 200, 50, 50);
    }
}
