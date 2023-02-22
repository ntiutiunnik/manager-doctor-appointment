package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.repository.NativeQueryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;

public class NativeQueryRepositoryImpl implements NativeQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void executeNativeQuery(String query) {
        if (StringUtils.isEmpty(query)) {
            return;
        }

        entityManager.createNativeQuery(query).getFirstResult();
    }
}
