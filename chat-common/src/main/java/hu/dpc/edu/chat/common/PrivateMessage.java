package hu.dpc.edu.chat.common;

/**
 *
 * @author IQJB
 */
public class PrivateMessage implements Message {
    private String sender;
    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.USER;
    }
    
    @Override
    public String toString() {
        return sender + ": " + message;
    }
}
