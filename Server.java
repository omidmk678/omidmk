import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    private static final int NUMBER_OF_CLIENTS = 3;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        //open server
        try (ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            //open socket for server
            for (int i = 0; i < NUMBER_OF_CLIENTS; i++){
                Socket socket = serverSocket.accept();
                System.out.println("Server Just connected to " + socket.getRemoteSocketAddress());
                pool.execute(new Handler(socket, i + 1));
            }
            pool.shutdown();
            System.out.println("Done.\nClosing server...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done.");
    }
}