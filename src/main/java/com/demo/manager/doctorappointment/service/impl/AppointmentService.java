package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.AppointmentDto;
import com.demo.manager.doctorappointment.exception.CustomCrudException;
import com.demo.manager.doctorappointment.mapper.impl.AppointmentMapper;
import com.demo.manager.doctorappointment.model.impl.Appointment;
import com.demo.manager.doctorappointment.repository.impl.AppointmentRepository;
import com.demo.manager.doctorappointment.service.AbstractService;
import com.demo.manager.doctorappointment.specification.AppointmentSpecification;
import com.demo.manager.doctorappointment.specification.filter.AppointmentFilterParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService extends AbstractService<Appointment, Long, AppointmentDto, AppointmentMapper, AppointmentRepository> {
    private static final Logger logger = LogManager.getLogger(AppointmentService.class);

    public AppointmentService(AppointmentMapper appointmentMapper,
                              AppointmentRepository appointmentRepository) {
        super(appointmentMapper, appointmentRepository);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void restartNumberSequence() {
        logger.info("Going to restart appointment number sequence.");

        restartAppointmentNumberSequence();
        logger.info("Appointment number sequence restarted successfully.");
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

    private void restartAppointmentNumberSequence() {
        repository.executeNativeQuery("ALTER SEQUENCE appointment_number_seq RESTART");
    }
}
