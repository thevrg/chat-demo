package hu.dpc.edu.chat.server;

import hu.dpc.edu.chat.common.Message;

/**
 *
 * @author IQJB
 */
public interface ChatClient {
    public String getName();
    public void send(Message message);
}
