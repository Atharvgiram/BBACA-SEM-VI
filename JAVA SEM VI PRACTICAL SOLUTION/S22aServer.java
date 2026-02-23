import java.io.*;
import java.net.*;
import java.util.Date;

public class S22aServer {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server Started...");

        Socket s = ss.accept();

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        Date d = new Date();
        out.println("Server Date and Time: " + d.toString());

        s.close();
        ss.close();
    }
}
