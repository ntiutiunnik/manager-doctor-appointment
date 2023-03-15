package com.demo.manager.doctorappointment.specification.filter.impl;

import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import io.swagger.v3.oas.annotations.Parameter;

public class DoctorScheduleFilterParam extends FilterParam {

    @Parameter(name = "doctor_id")
    private Long doctorId;

    @Parameter(name = "time_slot_id")
    private Long timeSlotId;

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
