
package com.leysoft.service.imple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

import com.leysoft.dto.MessageRequest;
import com.leysoft.service.inter.CustomMessageSink;
import com.leysoft.service.inter.ReceiverService;

@Service
public class ReceiverServiceImp implements ReceiverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverServiceImp.class);

    @Override
    @StreamListener(
            value = Processor.INPUT)
    public void receive(MessageRequest message) {
        LOGGER.info("receive message: {}", message.getMessage());
    }

    @Override
    @StreamListener(
            value = CustomMessageSink.INPUT)
    public void receiveCustomMessageSink(MessageRequest message) {
        LOGGER.info("receive message: {}", message.getMessage());
    }
}
