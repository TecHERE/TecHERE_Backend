package com.techere.project.kafkachat.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessage implements Serializable {

    private String author;
    private String content;
    private String timestamp;
}