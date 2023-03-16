package com.demo.manager.doctorappointment.specification.filter.impl;

import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import io.swagger.v3.oas.annotations.Parameter;

import java.beans.ConstructorProperties;

public class DoctorScheduleFilterParam implements FilterParam {

    @Parameter(name = "doctor_id")
    private Long doctorId;

    @Parameter(name = "time_slot_id")
    private Long timeSlotId;

    @ConstructorProperties({"doctor_id", "time_slot_id"})
    public DoctorScheduleFilterParam(Long doctorId, Long timeSlotId) {
        this.doctorId = doctorId;
        this.timeSlotId = timeSlotId;
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
