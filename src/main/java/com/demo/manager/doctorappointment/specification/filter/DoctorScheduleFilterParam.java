package com.demo.manager.doctorappointment.specification.filter;

import com.demo.manager.doctorappointment.util.RequestParamParser;

import javax.servlet.http.HttpServletRequest;

public class DoctorScheduleFilterParam {
    private Long doctorId;

    private Long timeSlotId;

    protected DoctorScheduleFilterParam(Long doctorId, Long timeSlotId) {
        this.doctorId = doctorId;
        this.timeSlotId = timeSlotId;
    }

    public static DoctorScheduleFilterParam of(HttpServletRequest httpServletRequest) {
        Long doctorId = RequestParamParser.getLongValue(httpServletRequest, "doctor_id");
        Long timeSlotId = RequestParamParser.getLongValue(httpServletRequest, "time_slot_id");

        return new DoctorScheduleFilterParam(doctorId, timeSlotId);
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }
}
