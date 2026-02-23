class Table {

    synchronized void printTable(int n) {

        for(int i = 1; i <= 5; i++) {

            System.out.println(n * i);

            try {
                Thread.sleep(500);
            } catch(Exception e) {}
        }
    }
}

class MyThread extends Thread {

    Table t;
    int num;

    MyThread(Table t, int num) {
        this.t = t;
        this.num = num;
    }

    public void run() {
        t.printTable(num);
    }
}

public class S28a {

    public static void main(String[] args) {

        Table obj = new Table();

        MyThread t1 = new MyThread(obj, 5);
        MyThread t2 = new MyThread(obj, 10);

        t1.start();
        t2.start();
    }
}
