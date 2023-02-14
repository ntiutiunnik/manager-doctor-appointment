package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long>, JpaSpecificationExecutor<DoctorSchedule> {
}
