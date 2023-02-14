package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
