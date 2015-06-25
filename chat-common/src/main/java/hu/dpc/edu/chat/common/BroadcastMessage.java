package hu.dpc.edu.chat.common;

/**
 *
 * @author IQJB
 */
public class BroadcastMessage implements Message {
    private String sender;
    private String message;
    private MessageType messageType;

    public BroadcastMessage() {
    }

    public BroadcastMessage(String user, String message) {
        this.sender = user;
        this.message = message;
    }

    public BroadcastMessage(String sender, String message, MessageType messageType) {
        this.sender = sender;
        this.message = message;
        this.messageType = messageType;
    }
    
    @Override
    public MessageType getMessageType() {
        return messageType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return sender + ": " + message;
    }
}
