package com.demo.manager.doctorappointment.model;

public interface BasicEntity<T, ID> {

    ID getId();

    Class<? extends T> getEntityClass();
}
