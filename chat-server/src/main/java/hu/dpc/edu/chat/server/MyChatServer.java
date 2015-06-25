package hu.dpc.edu.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author IQJB
 */
public class MyChatServer {

    private int port;

    private ChatRouter router;

    private ExecutorService executorService;

    public MyChatServer(int port, ChatRouter router) {
        this.port = port;
        this.router = router;
        executorService = Executors.newFixedThreadPool(10);
    }

    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Started MyChatServer on port " + port);
        while (true) {
            Socket socket = ss.accept();
            ChatClientHandler clientHandler = new ChatClientHandler(socket, router);

            executorService.submit(clientHandler);
        }
    }

    public static void main(String[] args) throws IOException {
        new MyChatServer(8888, new ChatRouterImpl()).start();
    }
}
