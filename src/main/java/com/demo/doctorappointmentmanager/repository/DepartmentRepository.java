package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
