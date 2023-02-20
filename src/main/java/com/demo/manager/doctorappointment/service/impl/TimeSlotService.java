package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.TimeSlotDto;
import com.demo.manager.doctorappointment.exception.CustomCrudException;
import com.demo.manager.doctorappointment.mapper.impl.TimeSlotMapper;
import com.demo.manager.doctorappointment.model.impl.TimeSlot;
import com.demo.manager.doctorappointment.repository.impl.TimeSlotRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TimeSlotService extends AbstractService<TimeSlot, Long, TimeSlotDto, TimeSlotMapper, TimeSlotRepository> {

    public TimeSlotService(TimeSlotMapper timeSlotMapper,
                           TimeSlotRepository timeSlotRepository) {
        super(timeSlotMapper, timeSlotRepository);
    }

    @Override
    protected void beforeSave(TimeSlotDto timeSlotDto) {
        LocalDateTime startTime = timeSlotDto.getStartTime();
        LocalDateTime endTime = timeSlotDto.getEndTime();

        if (startTime == null || endTime == null || ChronoUnit.MINUTES.between(startTime, endTime) != 30) {
            throw new CustomCrudException("Timeslot should be exactly 30 minutes long.");
        }
    }
}
