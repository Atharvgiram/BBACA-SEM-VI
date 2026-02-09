import java.net.*;

public class S11ClientIP {

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        System.out.println("Connected to Server");

        s.close();
    }
}
