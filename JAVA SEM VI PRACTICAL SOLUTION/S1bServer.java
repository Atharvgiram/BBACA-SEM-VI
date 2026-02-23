import java.io.*;
import java.net.*;

public class S1bServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is waiting...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            // Receive message from client
            String clientMsg = in.readLine();
            System.out.println("Client: " + clientMsg);

            // Send reply to client
            System.out.print("You: ");
            String serverMsg = keyboard.readLine();
            out.println(serverMsg);
        }
    }
}
