package com.techere.project.kafkachat.repository;

import com.techere.project.kafkachat.model.KafkaMessage;
import com.techere.project.kafkachat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Message, Long> {

}
