package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.impl.TimeSlotDto;
import com.demo.doctorappointmentmanager.mapper.impl.TimeSlotMapper;
import com.demo.doctorappointmentmanager.model.TimeSlot;
import com.demo.doctorappointmentmanager.repository.TimeSlotRepository;
import com.demo.doctorappointmentmanager.service.impl.TimeSlotService;
import com.demo.doctorappointmentmanager.util.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/time_slot")
public class TimeSlotController extends AbstractCrudController<TimeSlot, Long, TimeSlotDto, TimeSlotService, TimeSlotMapper, TimeSlotRepository> {

    public TimeSlotController(TimeSlotService timeSlotService) {
        super(timeSlotService);
    }
}
