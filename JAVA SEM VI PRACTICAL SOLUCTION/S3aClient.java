import java.io.*;
import java.net.*;
import java.util.Scanner;

public class S3aClient {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        dos.writeInt(num);

        String result = dis.readUTF();
        System.out.println("Result: " + result);

        s.close();
    }
}
