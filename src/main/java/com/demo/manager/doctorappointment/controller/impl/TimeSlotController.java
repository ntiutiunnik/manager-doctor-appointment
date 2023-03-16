package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.dto.impl.TimeSlotDto;
import com.demo.manager.doctorappointment.service.impl.TimeSlotService;
import com.demo.manager.doctorappointment.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/time_slot")
public class TimeSlotController extends PagingCrudControllerImpl<TimeSlotDto, Long> {

    public TimeSlotController(TimeSlotService timeSlotService) {
        super(timeSlotService);
    }
}
