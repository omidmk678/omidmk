import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args){
        String host = "127.0.0.1";
        int port = 5000;
        System.out.println("Connecting to " + host + " on port " + port);
        //open socket for client
        try (Socket socket = new Socket(host, port)){
            System.out.println("Client Just connected to " + socket.getRemoteSocketAddress());
            try (DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
                 DataInputStream inFromServer = new DataInputStream(socket.getInputStream())){
                Scanner scanner = new Scanner(System.in);
                String strToSend = "", readMessage;
                while (!strToSend.toLowerCase().equals("over")) {
                    //sending data to server
                    System.out.println("Send something to server :");
                    strToSend = scanner.nextLine();
                    outToServer.write(strToSend.getBytes());
                    System.out.format("\"%s\" SENT by client.\n", strToSend);

                    //receiving data from server
                    byte[] buffer = new byte[2048];
                    int count = inFromServer.read(buffer);
                    readMessage = new String(buffer, 0, count);
                    System.out.format("\"%s\" RECEIVED by client.\n", readMessage);
                }
                System.out.println("\nFinished.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Closing client socket...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done.");
    }
}
