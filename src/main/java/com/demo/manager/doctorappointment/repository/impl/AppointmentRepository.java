package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.model.impl.Appointment;
import com.demo.manager.doctorappointment.repository.CustomTransactionalSpecificationRepository;
import com.demo.manager.doctorappointment.repository.NativeQueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends CustomTransactionalSpecificationRepository<Appointment, Long>,  NativeQueryRepository {

    @Override
    @EntityGraph(attributePaths = {
            "doctorSchedule",
            "account",
            "doctorSchedule.doctor",
            "doctorSchedule.timeSlot"
    })
    Page<Appointment> findAll(Specification<Appointment> spec, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {
            "doctorSchedule",
            "account",
            "doctorSchedule.doctor",
            "doctorSchedule.timeSlot"
    })
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<Appointment> findById(Long id);

    @EntityGraph(attributePaths = {
            "doctorSchedule",
            "account",
            "doctorSchedule.doctor",
            "doctorSchedule.timeSlot"
    })
    List<Appointment> findAllByDoctorScheduleTimeSlotStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
