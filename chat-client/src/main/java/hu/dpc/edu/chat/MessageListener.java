package hu.dpc.edu.chat;

import hu.dpc.edu.chat.common.Message;

/**
 *
 * @author IQJB
 */
public interface MessageListener {
    public void handleMessage(Message message);
}
