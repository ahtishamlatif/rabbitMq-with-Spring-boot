package com.developer.queue.servicesImp;

import com.developer.queue.requestDto.QueueRequestDTO;
import com.developer.queue.services.QueueService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImp  implements QueueService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueueServiceImp.class);

     @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;
    @Value("${spring.rabbitmq.queue}")
    private String queue;
    @Override
    public ResponseEntity sendMessageToQueue(QueueRequestDTO requestDTO) {
        ResponseEntity response=null;
        LOGGER.info("Message Sending TO Queue");
        try {
            rabbitTemplate.convertAndSend(exchange,routingKey,requestDTO);
            response=ResponseEntity.ok("Message Sent Successfully");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            response=new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return response;
    }

}
