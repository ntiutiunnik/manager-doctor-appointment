package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.model.impl.Doctor;
import com.demo.manager.doctorappointment.repository.CustomTransactionalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DoctorRepository extends CustomTransactionalRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {

    @Override
    @EntityGraph(attributePaths = {
            "department"
    })
    Page<Doctor> findAll(Specification<Doctor> spec, Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {
            "department"
    })
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<Doctor> findById(Long id);
}
