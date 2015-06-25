package hu.dpc.edu.chat;

import hu.dpc.edu.chat.common.Message;

/**
 *
 * @author IQJB
 */
public interface ChatModel {
    void sendMessage(Message message);
    void addMessageListener(MessageListener listener);
    void removeMessageListener(MessageListener listener);
    void connect();
}
