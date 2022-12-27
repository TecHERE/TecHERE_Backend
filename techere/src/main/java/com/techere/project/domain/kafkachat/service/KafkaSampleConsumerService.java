package com.techere.project.domain.kafkachat.service;

import com.techere.project.domain.kafkachat.constants.KafkaConstants;
import com.techere.project.domain.kafkachat.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaSampleConsumerService {
    private final SimpMessagingTemplate template;

    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void listen(KafkaMessage message) {
        log.info("sending via kafka listener..");
        template.convertAndSend("/topic/group", message);
    }
}