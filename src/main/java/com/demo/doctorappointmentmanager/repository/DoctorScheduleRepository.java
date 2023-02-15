package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.DoctorSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long>, JpaSpecificationExecutor<DoctorSchedule> {

    @Override
    @EntityGraph(attributePaths = {
            "doctor",
            "timeSlot",
            "appointment"
    })
    Page<DoctorSchedule> findAll(Specification<DoctorSchedule> spec, Pageable pageable);
}
