
package com.leysoft.service.inter;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomMessageSink {

    String INPUT = "custom-message-channel";

    @Input(
            value = INPUT)
    SubscribableChannel input();
}
