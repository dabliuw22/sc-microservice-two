
package com.leysoft.service.inter;

import com.leysoft.dto.MessageRequest;

public interface ReceiverService {

    public void receive(MessageRequest message);

    public void receiveCustomMessageSink(MessageRequest message);
}
