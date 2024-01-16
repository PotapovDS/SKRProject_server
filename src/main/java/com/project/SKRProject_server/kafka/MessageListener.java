package com.project.SKRProject_server.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class MessageListener {

    @KafkaListener(topics="SKRProject_server")
    public void handle(){
        System.out.println("kafka handle message");
    }
}
