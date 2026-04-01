import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            // Create server on port 6000
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server is running on port 6000...");
            System.out.println("Waiting for client connection...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected successfully.");

            // Input stream from client
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Output stream to client
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            String message;

            // Continuous communication
            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);

                // Echo back to client
                output.println("Echo: " + message);

                // Stop if client types exit
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Close connections
            socket.close();
            serverSocket.close();

            System.out.println("Server stopped.");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}