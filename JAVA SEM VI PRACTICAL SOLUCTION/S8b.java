import java.applet.Applet;
import java.awt.*;
import java.util.Date;

/*
<applet code="S8b.class" width="300" height="150">
</applet>
*/

public class S8b extends Applet implements Runnable {

    String time = "";

    public void start() {
        new Thread(this).start();
    }

    public void run() {
        while(true) {
            time = new Date().toString();
            repaint();
            try { Thread.sleep(1000); } catch(Exception e) {}
        }
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(time, 20, 80);
    }
}
