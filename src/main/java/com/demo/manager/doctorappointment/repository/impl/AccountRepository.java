package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.model.impl.Account;
import com.demo.manager.doctorappointment.repository.CustomTransactionalRepository;

public interface AccountRepository extends CustomTransactionalRepository<Account, Long> {
}
