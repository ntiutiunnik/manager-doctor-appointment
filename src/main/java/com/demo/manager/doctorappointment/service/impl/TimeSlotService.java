package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.TimeSlotDto;
import com.demo.manager.doctorappointment.mapper.impl.TimeSlotMapper;
import com.demo.manager.doctorappointment.model.impl.TimeSlot;
import com.demo.manager.doctorappointment.repository.impl.TimeSlotRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotService extends AbstractService<TimeSlot, Long, TimeSlotDto, TimeSlotMapper, TimeSlotRepository> {
    public TimeSlotService(TimeSlotMapper timeSlotMapper,
                           TimeSlotRepository timeSlotRepository) {
        super(timeSlotMapper, timeSlotRepository);
    }
}
