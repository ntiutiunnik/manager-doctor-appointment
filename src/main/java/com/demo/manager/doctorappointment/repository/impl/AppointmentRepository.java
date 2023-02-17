package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.model.impl.Appointment;
import com.demo.manager.doctorappointment.repository.CustomTransactionalRepository;
import com.demo.manager.doctorappointment.repository.NativeQueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AppointmentRepository extends CustomTransactionalRepository<Appointment, Long>, JpaSpecificationExecutor<Appointment>, NativeQueryRepository {

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
}
