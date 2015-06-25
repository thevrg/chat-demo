package hu.dpc.edu.chat;

import hu.dpc.edu.chat.common.Message;
import hu.dpc.edu.chat.common.SystemMessage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IQJB
 */
public class ChatModelNetworkImpl implements ChatModel {

    private List<MessageListener>listeners = new ArrayList<>();
    
    @Override
    public void connect() {
        
        fireMessageReceivedEvent(new SystemMessage("Started"));
        //TODO: implement
    }
    
    @Override
    public void sendMessage(Message message) {
        //TODO: implement
    }

    protected void fireMessageReceivedEvent(Message message) {
        for (MessageListener listener : listeners) {
            listener.handleMessage(message);
        }
    }
    
    @Override
    public void addMessageListener(MessageListener listener) {
        listeners.add(listener);
    }
    
    @Override
    public void removeMessageListener(MessageListener listener) {
        listeners.remove(listener);
    }
}
