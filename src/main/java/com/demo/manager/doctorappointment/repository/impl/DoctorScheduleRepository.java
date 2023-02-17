package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import com.demo.manager.doctorappointment.repository.CustomTransactionalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DoctorScheduleRepository extends CustomTransactionalRepository<DoctorSchedule, Long>, JpaSpecificationExecutor<DoctorSchedule> {

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
