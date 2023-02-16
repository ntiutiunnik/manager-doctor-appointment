package com.demo.doctorappointmentmanager.specification.filter;

import jakarta.servlet.http.HttpServletRequest;

import static com.demo.doctorappointmentmanager.util.RequestParamParser.getLongValue;

public class DoctorScheduleFilterParam {
    private Long doctorId;

    private Long timeSlotId;

    protected DoctorScheduleFilterParam(Long doctorId, Long timeSlotId) {
        this.doctorId = doctorId;
        this.timeSlotId = timeSlotId;
    }

    public static DoctorScheduleFilterParam of(HttpServletRequest httpServletRequest) {
        Long doctorId = getLongValue(httpServletRequest, "doctor_id");
        Long timeSlotId = getLongValue(httpServletRequest, "time_slot_id");

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
