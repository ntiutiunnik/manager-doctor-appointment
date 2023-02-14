package com.demo.doctorappointmentmanager.specification.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class DoctorScheduleFilterParam {
    private Long doctorId;

    protected DoctorScheduleFilterParam(Long doctorId) {
        this.doctorId = doctorId;
    }

    public static DoctorScheduleFilterParam of(HttpServletRequest httpServletRequest) {
        String doctorIdString = httpServletRequest.getParameter("doctor_id");
        Long doctorId = StringUtils.isEmpty(doctorIdString) ? null : Long.parseLong(doctorIdString);

        return new DoctorScheduleFilterParam(doctorId);
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
