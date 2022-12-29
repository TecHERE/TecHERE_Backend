package com.techere.project.domain.kafkachat.service;

import com.techere.project.domain.kafkachat.repository.ChatRepository;
import com.techere.project.domain.kafkachat.model.KafkaMessage;
import com.techere.project.domain.kafkachat.model.Message;
import com.techere.project.domain.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final RoomRepository roomRepository;

    public Message create(KafkaMessage message, Long roomId) {
        return chatRepository.save(Message.builder()
                        .room(roomRepository.findById(roomId).orElseThrow())
                .content(message.getContent())
                .author(message.getAuthor())
                .timestamp(message.getTimestamp()).build());
    }
}
