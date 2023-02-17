package com.demo.manager.doctorappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@NoRepositoryBean
public interface CustomTransactionalRepository<T, ID> extends JpaRepository<T, ID> {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    <S extends T> S save(S entity);

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<T> findById(ID id);
}