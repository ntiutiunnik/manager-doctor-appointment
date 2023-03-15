package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import com.demo.manager.doctorappointment.repository.CustomTransactionalSpecificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DoctorScheduleRepository extends CustomTransactionalSpecificationRepository<DoctorSchedule, Long> {

    @Override
    @EntityGraph(attributePaths = {
            "doctor",
            "timeSlot",
            "appointment"
    })
    Page<DoctorSchedule> findAll(Specification<DoctorSchedule> spec, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {
            "doctor",
            "timeSlot",
            "appointment"
    })
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<DoctorSchedule> findById(Long id);
}
