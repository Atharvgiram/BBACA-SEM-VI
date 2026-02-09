class MyThread extends Thread {

    public void run() {
        System.out.println("Currently Executing Thread: "
                + Thread.currentThread().getName());
    }
}

public class S13a {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();

        System.out.println("Main Thread: "
                + Thread.currentThread().getName());
    }
}
