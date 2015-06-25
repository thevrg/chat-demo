package hu.dpc.edu.chat;

import hu.dpc.edu.chat.common.Message;

/**
 *
 * @author IQJB
 */
public interface ChatView {
    public void printReceivedMessage(Message message);
    public void clear();
}
