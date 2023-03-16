package com.demo.manager.doctorappointment.controller.impl;

import com.demo.manager.doctorappointment.dto.impl.AppointmentDto;
import com.demo.manager.doctorappointment.service.impl.AppointmentService;
import com.demo.manager.doctorappointment.specification.filter.impl.AppointmentFilterParam;
import com.demo.manager.doctorappointment.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/appointment")
public class AppointmentController extends PagingAndFilteringCrudControllerImpl<AppointmentDto, Long, AppointmentFilterParam> {

    public AppointmentController(AppointmentService appointmentService) {
        super(appointmentService);
    }
}
