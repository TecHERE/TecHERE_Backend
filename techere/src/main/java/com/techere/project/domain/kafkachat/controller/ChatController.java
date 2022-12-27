package com.techere.project.domain.kafkachat.controller;

import com.techere.project.domain.kafkachat.constants.KafkaConstants;
import com.techere.project.domain.kafkachat.dto.mapper.ChatMapper;
import com.techere.project.domain.kafkachat.dto.request.MessageRequestDto;
import com.techere.project.domain.kafkachat.service.ChatService;
import com.techere.project.domain.kafkachat.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class ChatController {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    private final ChatService chatService;
    private final ChatMapper chatMapper;

    @MessageMapping("/messages")
    @SendTo("/topic/group")
    @PostMapping("/messages/{roomId}")

    public String send_message(@RequestBody MessageRequestDto message, @PathVariable Long roomId) {
        KafkaMessage kafkaMessage = chatMapper.toKafkaMessage(message);

        log.info("Produce message : " + message.toString());
        try {
            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, kafkaMessage).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        chatService.create(kafkaMessage, roomId);
        return "success";
    }


    //여기서 프론트엔드로 메시지를 전송
//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/group")
//    public Message broadcastGroupMessage(@Payload Message message) {
//        return message;
//    }

}
