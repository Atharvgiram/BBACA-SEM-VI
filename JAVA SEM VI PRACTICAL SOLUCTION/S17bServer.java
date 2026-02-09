import java.io.*;
import java.net.*;

public class S17bServer {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(
                s.getOutputStream(), true);

        String fileName = in.readLine();
        File f = new File(fileName);

        if(f.exists()) {

            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            while((line = br.readLine()) != null) {
                out.println(line);
            }

            br.close();

        } else {
            out.println("File Not Found");
        }

        s.close();
        ss.close();
    }
}
