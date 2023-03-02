package com.demo.manager.doctorappointment.service.impl;

import com.demo.manager.doctorappointment.dto.impl.AppointmentDto;
import com.demo.manager.doctorappointment.exception.CustomCrudException;
import com.demo.manager.doctorappointment.mapper.impl.AppointmentMapper;
import com.demo.manager.doctorappointment.messaging.AppointmentHistoryPublisher;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService extends AbstractService<Appointment, Long, AppointmentDto, AppointmentMapper, AppointmentRepository> {
    private static final Logger logger = LogManager.getLogger(AppointmentService.class);

    private final AppointmentHistoryPublisher appointmentHistoryPublisher;

    public AppointmentService(AppointmentMapper appointmentMapper,
                              AppointmentRepository appointmentRepository,
                              AppointmentHistoryPublisher appointmentHistoryPublisher) {
        super(appointmentMapper, appointmentRepository);
        this.appointmentHistoryPublisher = appointmentHistoryPublisher;
    }

//    @Scheduled(cron = "0 30 23 * * *")
    public void sendAppointmentHistory() {
        LocalDate now = LocalDate.now();
        logger.info("Going to send appointment history for {}.", now);

        try {
            List<Appointment> appointments = repository.findAllByDoctorScheduleTimeSlotStartTimeBetween(now.atStartOfDay(), getEndTimeSlot(now));
            appointmentHistoryPublisher.sendAppointmentHistory(mapper.entitiesToDtos(appointments));
            logger.info("Appointment history sent successfully.");
        } catch (Exception e) {
            logger.error("An exception occurred while sending appointment history: {}.", e.getMessage());
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void restartNumberSequence() {
        logger.info("Going to restart appointment number sequence.");

        try {
            restartAppointmentNumberSequence();
            logger.info("Appointment number sequence restarted successfully.");
        } catch (Exception e) {
            logger.error("An exception occurred while restarting appointment number sequence: {}.", e.getMessage());
        }
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

    private LocalDateTime getEndTimeSlot(LocalDate localDate) {
        return localDate.atStartOfDay().plusDays(1L).minusMinutes(1L);
    }

    private void restartAppointmentNumberSequence() {
        repository.executeNativeQuery("ALTER SEQUENCE appointment_number_seq RESTART");
    }
}
