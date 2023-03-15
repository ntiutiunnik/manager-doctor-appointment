package com.demo.manager.doctorappointment.specification.filter.impl;


import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import io.swagger.v3.oas.annotations.Parameter;

public class AppointmentFilterParam extends FilterParam {

    @Parameter(name = "account_id")
    private Long accountId;

    @Parameter(name = "doctor_id")
    private Long doctorId;

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
