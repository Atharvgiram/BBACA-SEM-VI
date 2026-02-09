import java.applet.Applet;
import java.awt.*;
import java.util.Random;

/*
<applet code="S3b.class" width="400" height="300">
</applet>
*/

public class S3b extends Applet implements Runnable {

    int x = 50, y = 50;      // Ball position
    int dx = 3, dy = 3;      // Speed
    int radius = 20;

    Thread t;
    Color ballColor = Color.RED;
    Random r = new Random();

    public void start() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while(true) {

            x += dx;
            y += dy;

            // Bounce from left or right wall
            if(x <= 0 || x >= getWidth() - radius*2) {
                dx = -dx;
                changeColor();
            }

            // Bounce from top or bottom wall
            if(y <= 0 || y >= getHeight() - radius*2) {
                dy = -dy;
                changeColor();
            }

            repaint();

            try {
                Thread.sleep(20);
            } catch(Exception e) {}
        }
    }

    public void paint(Graphics g) {
        g.setColor(ballColor);
        g.fillOval(x, y, radius*2, radius*2);
    }

    // Random color generator
    public void changeColor() {
        ballColor = new Color(r.nextInt(256),
                              r.nextInt(256),
                              r.nextInt(256));
    }
}
