package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
