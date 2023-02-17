package com.demo.manager.doctorappointment.specification.filter;

import jakarta.servlet.http.HttpServletRequest;

import static com.demo.manager.doctorappointment.util.RequestParamParser.getLongValue;

public class AppointmentFilterParam {
    private Long accountId;

    private Long doctorId;

    protected AppointmentFilterParam(Long accountId, Long doctorId) {
        this.accountId = accountId;
        this.doctorId = doctorId;
    }

    public static AppointmentFilterParam of(HttpServletRequest httpServletRequest) {
        Long accountId = getLongValue(httpServletRequest, "account_id");
        Long doctorId = getLongValue(httpServletRequest, "doctor_id");

        return new AppointmentFilterParam(accountId, doctorId);
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
