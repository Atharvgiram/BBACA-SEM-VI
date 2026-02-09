import java.io.*;
import java.net.*;

public class S3aServer {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int n = dis.readInt();
        boolean prime = true;

        if(n <= 1)
            prime = false;

        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                prime = false;
                break;
            }
        }

        if(prime)
            dos.writeUTF("Prime");
        else
            dos.writeUTF("Not Prime");

        s.close();
        ss.close();
    }
}
