package hu.dpc.edu.chat.server;

import hu.dpc.edu.chat.common.Message;

/**
 *
 * @author IQJB
 */
public interface ChatRouter {
    public void broadcast(Message message);
    public void registerClient(ChatClient chatClient);
    public void unregisterClient(ChatClient chatClient);
}
