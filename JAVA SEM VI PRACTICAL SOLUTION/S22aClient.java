import java.io.*;
import java.net.*;

public class S22aClient {

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        String msg = in.readLine();

        System.out.println(msg);

        s.close();
    }
}
