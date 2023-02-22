package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.controller.AbstractCrudController;
import com.demo.manager.doctorappointment.dto.impl.TimeSlotDto;
import com.demo.manager.doctorappointment.mapper.impl.TimeSlotMapper;
import com.demo.manager.doctorappointment.model.impl.TimeSlot;
import com.demo.manager.doctorappointment.repository.impl.TimeSlotRepository;
import com.demo.manager.doctorappointment.service.impl.TimeSlotService;
import com.demo.manager.doctorappointment.util.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/time_slot")
public class TimeSlotController extends AbstractCrudController<TimeSlot, Long, TimeSlotDto, TimeSlotService, TimeSlotMapper, TimeSlotRepository> {

    public TimeSlotController(TimeSlotService timeSlotService) {
        super(timeSlotService);
    }
}
