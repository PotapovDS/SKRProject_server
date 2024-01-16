package com.project.SKRProject_server.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageSender {

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg, String topicName){
        log.info("Sending : {}", msg);
        kafkaTemplate.send(topicName, msg);
    }
}
