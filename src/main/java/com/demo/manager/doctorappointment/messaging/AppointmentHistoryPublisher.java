package com.demo.manager.doctorappointment.messaging;

import com.demo.manager.doctorappointment.dto.impl.AppointmentDto;
import com.demo.manager.doctorappointment.messaging.impl.KafkaPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentHistoryPublisher implements KafkaPublisher<AppointmentDto> {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, AppointmentDto> kafkaTemplate;

    public AppointmentHistoryPublisher(KafkaTemplate<String, AppointmentDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @NonNull
    public KafkaTemplate<String, AppointmentDto> kafkaTemplate() {
        return kafkaTemplate;
    }

    public void sendAppointmentHistory(List<AppointmentDto> appointmentDtos) {
        sendMessages(topicName, appointmentDtos);
    }
}
