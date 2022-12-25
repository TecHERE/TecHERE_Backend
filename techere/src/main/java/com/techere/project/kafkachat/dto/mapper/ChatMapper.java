package com.techere.project.kafkachat.dto.mapper;

import com.techere.project.kafkachat.dto.request.MessageRequestDto;
import com.techere.project.kafkachat.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ChatMapper {

    public KafkaMessage toKafkaMessage(MessageRequestDto dto) {
        return KafkaMessage.builder()
                .content(dto.getContent())
                .author(dto.getAuthor())
                .timestamp(LocalDateTime.now().toString())
                .build();
    }
}
