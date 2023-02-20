package com.demo.manager.doctorappointment.messaging.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;

import java.util.List;

public interface KafkaPublisher<T> {

    @NonNull
    KafkaTemplate<String, T> kafkaTemplate();

    default void sendMessages(String topicName, List<T> messages) {
        if (StringUtils.isEmpty(topicName)) {
            throw new RuntimeException("No topic provided for message sending.");
        }

        messages.forEach(message -> kafkaTemplate().send(topicName, message));
    }
}
