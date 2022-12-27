package com.techere.project.domain.kafkachat.repository;

import com.techere.project.domain.kafkachat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Message, Long> {

}
