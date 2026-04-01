import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            // Connect to server on port 6000
            Socket socket = new Socket("localhost", 6000);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            String message;

            while (true) {
                System.out.print("Enter message: ");
                message = sc.nextLine();

                // Send message to server
                output.println(message);

                // Receive response
                String response = input.readLine();
                System.out.println("Server Response: " + response);

                // Exit condition
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}