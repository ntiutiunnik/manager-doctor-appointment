package com.demo.manager.doctorappointment.repository.impl;

import com.demo.manager.doctorappointment.repository.NativeQueryRepository;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
