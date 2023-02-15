package com.demo.doctorappointmentmanager.controller.impl;

import com.demo.doctorappointmentmanager.controller.AbstractCrudController;
import com.demo.doctorappointmentmanager.dto.impl.AppointmentDto;
import com.demo.doctorappointmentmanager.mapper.impl.AppointmentMapper;
import com.demo.doctorappointmentmanager.model.Appointment;
import com.demo.doctorappointmentmanager.repository.AppointmentRepository;
import com.demo.doctorappointmentmanager.service.impl.AppointmentService;
import com.demo.doctorappointmentmanager.util.resource.GeneralResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralResource.PATH + "/appointment")
public class AppointmentController extends AbstractCrudController<Appointment, Long, AppointmentDto, AppointmentService, AppointmentMapper, AppointmentRepository> {

    public AppointmentController(AppointmentService appointmentService) {
        super(appointmentService);
    }
}
