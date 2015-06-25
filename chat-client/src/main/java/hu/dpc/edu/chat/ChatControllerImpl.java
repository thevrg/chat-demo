package hu.dpc.edu.chat;

import hu.dpc.edu.chat.common.BroadcastMessage;
import hu.dpc.edu.chat.common.Message;

/**
 *
 * @author IQJB
 */
public class ChatControllerImpl implements ChatController{

    private ChatModel model;
    
    public ChatControllerImpl(ChatModel model) {
        this.model = model;
    }
    
    @Override
    public void sendMessage(BroadcastMessage message) {
        model.sendMessage(message);
    }
    
}
