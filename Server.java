import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        //open server
        try (ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            //open socket for server
            try (Socket socket = serverSocket.accept()){
                System.out.println("Server Just connected to " + socket.getRemoteSocketAddress());
                try(BufferedInputStream inFromClient = new BufferedInputStream(socket.getInputStream());
                    DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream())) {
                    String readMessage = "",clientMessage = "";
                    while(!readMessage.toLowerCase().equals("over")){
                        //receiving data from client
                        byte[] buffer = new byte[2048];
                        int count = inFromClient.read(buffer);
                        readMessage = new String(buffer, 0, count);
                        System.out.format("\"%s\" RECEIVED by server.\n", readMessage);
                        clientMessage = clientMessage.concat(readMessage);

                        //sending data to client
                        outToClient.write(clientMessage.getBytes());
                        System.out.format("\"%s\" SENT by server.\n", clientMessage);
                    }
                    System.out.println("Communication has been finished.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Closing client...");
            }catch (IOException ex){
                ex.printStackTrace();
            }
            System.out.println("Done.\nClosing server...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Done.");
    }
}