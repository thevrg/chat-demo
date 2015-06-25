package hu.dpc.edu.chat.server;

import hu.dpc.edu.chat.common.Message;
import hu.dpc.edu.chat.common.BroadcastMessage;
import hu.dpc.edu.chat.common.MessageType;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author IQJB
 */
public class ChatClientHandler implements Runnable, ChatClient {

    private final Socket conn;
    private final ChatRouter router;
    private ObjectOutputStream out;

    public ChatClientHandler(Socket connection, ChatRouter router) {
        this.conn = connection;
        this.router = router;
    }

    @Override
    public void run() {
        System.out.println("Connected: " + conn.getInetAddress());
        try {
            out = new ObjectOutputStream(conn.getOutputStream());
            
            send(new BroadcastMessage("System", 
                    "Hello, dear guest, logged in from: " + conn.getInetAddress(), 
                    MessageType.SYSTEM));
            
            router.registerClient(this);

            try (ObjectInputStream in = new ObjectInputStream(conn.getInputStream())) {
                Object received;
                while ((received = in.readObject()) != null) {
                    Message message = (Message) received;
                    router.broadcast(message);
                }
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException("Failed to decode stream, terminating connection" , ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException("IOException, terminating connection" , ex);
        } finally {
            router.unregisterClient(this);
            try {
                conn.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public synchronized void send(Message message) {
        if (out != null) {
            try {
                out.writeObject(message);
                out.flush();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public String getName() {
        return conn.getRemoteSocketAddress().toString();
    }
}
