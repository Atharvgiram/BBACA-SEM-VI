import java.io.*;
import java.net.*;
import java.util.Scanner;

public class S17bClient {

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        out.println(fileName);

        String line;

        while((line = in.readLine()) != null) {
            System.out.println(line);
        }

        s.close();
    }
}
