package com.developer.queue.controller;

import com.developer.queue.requestDto.QueueRequestDTO;
import com.developer.queue.servicesImp.QueueServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/queue/")
public class QueueController {

    @Autowired
    private QueueServiceImp queueServiceImp;


    @PostMapping("send/message")
    public ResponseEntity sendMessage(@RequestBody QueueRequestDTO requestDTO){
        return queueServiceImp.sendMessageToQueue(requestDTO);
    }



}
