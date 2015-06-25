package hu.dpc.edu.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author IQJB
 */
public class MyChatServer {

    private int port;
    
    private ChatRouter router;

    public MyChatServer(int port, ChatRouter router) {
        this.port = port;
        this.router = router;
    }

    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Started MyChatServer on port " + port);
        while (true) {
            Socket socket = ss.accept();
            ChatClientHandler clientHandler = new ChatClientHandler(socket, router);
            Thread t = new Thread(clientHandler);
            t.start();
        }
    }

    public static void main(String[] args) throws IOException {
        new MyChatServer(8888, new ChatRouterImpl()).start();
    }
}
