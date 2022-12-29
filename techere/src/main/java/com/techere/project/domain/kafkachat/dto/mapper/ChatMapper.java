package com.techere.project.domain.kafkachat.dto.mapper;

import com.techere.project.domain.kafkachat.dto.request.MessageRequestDto;
import com.techere.project.domain.kafkachat.model.KafkaMessage;
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
