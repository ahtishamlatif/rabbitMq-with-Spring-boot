package com.developer.queue.services;

import com.developer.queue.requestDto.QueueRequestDTO;
import org.springframework.http.ResponseEntity;

public interface QueueService {


    ResponseEntity sendMessageToQueue(QueueRequestDTO requestDTO);

}
