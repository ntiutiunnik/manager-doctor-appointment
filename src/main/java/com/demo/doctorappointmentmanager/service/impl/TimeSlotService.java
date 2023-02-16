package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.impl.TimeSlotDto;
import com.demo.doctorappointmentmanager.mapper.impl.TimeSlotMapper;
import com.demo.doctorappointmentmanager.model.TimeSlot;
import com.demo.doctorappointmentmanager.repository.TimeSlotRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotService extends AbstractService<TimeSlot, Long, TimeSlotDto, TimeSlotMapper, TimeSlotRepository> {
    public TimeSlotService(TimeSlotMapper timeSlotMapper,
                           TimeSlotRepository timeSlotRepository,
                           EntityManager entityManager) {
        super(timeSlotMapper, timeSlotRepository, entityManager);
    }
}
