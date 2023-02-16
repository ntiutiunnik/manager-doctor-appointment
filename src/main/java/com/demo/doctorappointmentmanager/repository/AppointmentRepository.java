package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment> {

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
    Optional<Appointment> findById(Long id);
}
