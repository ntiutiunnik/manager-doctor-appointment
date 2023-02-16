package com.demo.doctorappointmentmanager.repository;

import com.demo.doctorappointmentmanager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
