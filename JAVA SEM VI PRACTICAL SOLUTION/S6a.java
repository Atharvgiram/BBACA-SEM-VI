import javax.swing.*;
import java.awt.*;

public class S6a extends JPanel implements Runnable {

    Image img = new ImageIcon("image.jpg").getImage();
    boolean show = true;

    public S6a() {
        new Thread(this).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(show)
            g.drawImage(img, 100, 80, 300, 250, this);
    }

    public void run() {
        while(true) {
            show = !show;
            repaint();
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Blink Image");
        f.add(new S6a());
        f.setSize(600,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
