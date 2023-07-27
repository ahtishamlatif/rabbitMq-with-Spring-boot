package com.developer.queue.listener;

import com.developer.queue.requestDto.QueueRequestDTO;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueueListener.class);
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(QueueRequestDTO requestDTO) {
        LOGGER.info("Message Received From Queue : {}",new Gson().toJson(requestDTO));
    }
}
