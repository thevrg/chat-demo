package hu.dpc.edu.chat.common;

/**
 *
 * @author IQJB
 */
public class SystemMessage implements Message {

    private final String message;

    public SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.SYSTEM;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

}
