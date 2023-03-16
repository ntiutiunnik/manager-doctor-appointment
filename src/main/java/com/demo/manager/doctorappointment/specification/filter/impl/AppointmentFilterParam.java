package com.demo.manager.doctorappointment.specification.filter.impl;


import com.demo.manager.doctorappointment.specification.filter.FilterParam;

import java.beans.ConstructorProperties;

public class AppointmentFilterParam implements FilterParam {

    private Long accountId;

    private Long doctorId;

    @ConstructorProperties({"account_id", "doctor_id"})
    public AppointmentFilterParam(Long accountId, Long doctorId) {
        this.accountId = accountId;
        this.doctorId = doctorId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
