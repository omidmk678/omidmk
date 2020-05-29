import java.io.*;
import java.net.Socket;

public class Handler implements Runnable {

    private Socket socket;
    private int clientNumber;

    public Handler(Socket socket, int clientNumber){
        this.socket = socket;
        this.clientNumber = clientNumber;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try (BufferedInputStream inFromClient = new BufferedInputStream(socket.getInputStream());
             DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream())) {
            String readMessage = "", clientMessage = "";
            while (!readMessage.toLowerCase().equals("over")) {
                //receiving data from client
                byte[] buffer = new byte[2048];
                int count = inFromClient.read(buffer);
                readMessage = new String(buffer, 0, count);
                System.out.format("\"%s\" RECEIVED by server by client %d.\n", readMessage, clientNumber);
                clientMessage = clientMessage.concat(readMessage);

                //sending data to client
                outToClient.write(clientMessage.getBytes());
                System.out.format("\"%s\" SENT by server to client %d.\n", clientMessage, clientNumber);
            }
            System.out.println("Communication has been finished with client " + clientNumber + ".");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
