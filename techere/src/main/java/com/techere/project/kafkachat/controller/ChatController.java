package com.techere.project.kafkachat.controller;

import com.techere.project.kafkachat.constants.KafkaConstants;
import com.techere.project.kafkachat.dto.mapper.ChatMapper;
import com.techere.project.kafkachat.dto.request.MessageRequestDto;
import com.techere.project.kafkachat.model.KafkaMessage;
import com.techere.project.kafkachat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
public class ChatController {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    private final ChatService chatService;
    private final ChatMapper chatMapper;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public void send_message(@RequestBody MessageRequestDto message) {
        KafkaMessage kafkaMessage = chatMapper.toKafkaMessage(message);

        log.info("Produce message : " + message.toString());
        try {
            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, kafkaMessage).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        chatService.create(kafkaMessage);
    }


    //여기서 프론트엔드로 메시지를 전송
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/group")
//    public Message broadcastGroupMessage(@Payload Message message) {
//        return message;
//    }

}
