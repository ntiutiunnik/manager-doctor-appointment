package com.demo.manager.doctorappointment.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomTransactionalSpecificationRepository<T, ID> extends CustomTransactionalRepository<T, ID>, JpaSpecificationExecutor<T> {
}