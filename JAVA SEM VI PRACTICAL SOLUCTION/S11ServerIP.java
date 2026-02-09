import java.net.*;

public class S11ServerIP {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server Started... Waiting for Client");

        Socket s = ss.accept();

        InetAddress ip = s.getInetAddress();

        System.out.println("Client IP Address: " + ip.getHostAddress());
        System.out.println("Client Host Name: " + ip.getHostName());

        s.close();
        ss.close();
    }
}
