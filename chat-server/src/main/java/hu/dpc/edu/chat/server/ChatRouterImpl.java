package hu.dpc.edu.chat.server;

import hu.dpc.edu.chat.common.Message;
import hu.dpc.edu.chat.common.SystemMessage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class ChatRouterImpl implements ChatRouter {

    private List<ChatClient> clients = new ArrayList<>();

    @Override
    public synchronized void broadcast(Message message) {
        for (ChatClient client : clients) {
            client.send(message);
        }
    }

    @Override
    public synchronized void registerClient(ChatClient chatClient) {
        broadcast(new SystemMessage("Client logged in: " + chatClient.getName()));
        clients.add(chatClient);
    }

    @Override
    public synchronized void unregisterClient(ChatClient chatClient) {
        clients.remove(chatClient);
        broadcast(new SystemMessage("Client logged out: " + chatClient.getName()));
    }

}
