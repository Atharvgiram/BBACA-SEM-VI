import java.io.*;
import java.net.*;

public class S1bClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server!");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            // Send message to server
            System.out.print("You: ");
            String clientMsg = keyboard.readLine();
            out.println(clientMsg);

            // Receive reply from server
            String serverMsg = in.readLine();
            System.out.println("Server: " + serverMsg);
        }
    }
}
