package hu.dpc.edu.chat.common;

import java.io.Serializable;

/**
 *
 * @author IQJB
 */
public interface Message extends Serializable {
    
    MessageType getMessageType();
    
    @Override
    public String toString();
}
