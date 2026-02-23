public class S21a {

    public static void main(String[] args) {

        Thread t = new Thread();

        t.setName("MyThread");
        t.setPriority(7);

        System.out.println("Thread Name: " + t.getName());
        System.out.println("Thread Priority: " + t.getPriority());
    }
}
