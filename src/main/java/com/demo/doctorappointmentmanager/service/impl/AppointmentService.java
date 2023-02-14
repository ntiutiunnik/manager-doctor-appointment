package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.AppointmentDto;
import com.demo.doctorappointmentmanager.mapper.AppointmentMapper;
import com.demo.doctorappointmentmanager.model.Appointment;
import com.demo.doctorappointmentmanager.repository.AppointmentRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends AbstractService<Appointment, Long, AppointmentDto, AppointmentMapper, AppointmentRepository> {
    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository) {
        super(appointmentMapper, appointmentRepository);
    }
}
