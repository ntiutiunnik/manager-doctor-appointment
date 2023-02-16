package com.demo.doctorappointmentmanager.service.impl;

import com.demo.doctorappointmentmanager.dto.impl.AppointmentDto;
import com.demo.doctorappointmentmanager.exception.CustomCrudException;
import com.demo.doctorappointmentmanager.mapper.impl.AppointmentMapper;
import com.demo.doctorappointmentmanager.model.Appointment;
import com.demo.doctorappointmentmanager.repository.AppointmentRepository;
import com.demo.doctorappointmentmanager.service.AbstractService;
import com.demo.doctorappointmentmanager.specification.AppointmentSpecification;
import com.demo.doctorappointmentmanager.specification.filter.AppointmentFilterParam;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService extends AbstractService<Appointment, Long, AppointmentDto, AppointmentMapper, AppointmentRepository> {
    public AppointmentService(AppointmentMapper appointmentMapper,
                              AppointmentRepository appointmentRepository,
                              EntityManager entityManager) {
        super(appointmentMapper, appointmentRepository, entityManager);
    }

    public List<AppointmentDto> findAllAppointments(AppointmentFilterParam appointmentFilterParam, PageRequest pageRequest) {
        Page<Appointment> appointmentPage = repository.findAll(AppointmentSpecification.getFilteredAppointments(appointmentFilterParam), pageRequest);
        return mapper.entitiesToDtos(appointmentPage.getContent());
    }

    @Override
    protected void beforeSave(AppointmentDto appointmentDto) {
        if (appointmentDto.getNumber() != null) {
            throw new CustomCrudException("Number of appointment should be auto-generated.");
        }
    }
}
