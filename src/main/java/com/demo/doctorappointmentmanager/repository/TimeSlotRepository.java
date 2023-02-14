package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
