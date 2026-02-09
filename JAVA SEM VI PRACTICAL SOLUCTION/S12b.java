import java.util.Random;

class MyThread extends Thread {

    MyThread(String name) {
        super(name);   // set thread name
        System.out.println(getName() + " Created");
        start();       // start thread
    }

    public void run() {

        Random r = new Random();
        int sleepTime = r.nextInt(5000);  // 0 to 4999

        System.out.println(getName() + " Sleeping for " + sleepTime + " ms");

        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {}

        System.out.println(getName() + " Dead");
    }
}

public class S12b {

    public static void main(String[] args) {

        new MyThread("Thread-1");
        new MyThread("Thread-2");
        new MyThread("Thread-3");
    }
}
