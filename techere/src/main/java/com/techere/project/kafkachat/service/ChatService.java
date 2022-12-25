package com.techere.project.kafkachat.service;

import com.techere.project.kafkachat.dto.request.MessageRequestDto;
import com.techere.project.kafkachat.model.KafkaMessage;
import com.techere.project.kafkachat.model.Message;
import com.techere.project.kafkachat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public Message create(KafkaMessage message) {
        return chatRepository.save(Message.builder()
                .content(message.getContent())
                .author(message.getAuthor())
                .timestamp(message.getTimestamp()).build());
    }
}
