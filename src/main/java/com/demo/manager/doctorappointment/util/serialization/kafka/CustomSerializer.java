package com.demo.manager.doctorappointment.util.serialization.kafka;

import com.demo.manager.doctorappointment.dto.impl.AppointmentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class CustomSerializer implements Serializer<AppointmentDto> {
    private static final Logger logger = LogManager.getLogger(CustomSerializer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, AppointmentDto data) {
        try {
            if (data == null) {
                logger.info("Null received at serializing AppointmentDto.");
                return null;
            }

            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing AppointmentDto.");
        }
    }

    @Override
    public void close() {
    }
}