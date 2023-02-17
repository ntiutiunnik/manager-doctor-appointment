package com.demo.manager.doctorappointment.dto.impl;

import com.demo.manager.doctorappointment.dto.BasicDto;
import com.demo.manager.doctorappointment.dto.shortened.ShortDoctorDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorScheduleDto implements BasicDto<Long> {

    private Long id;

    private ShortDoctorDto doctor;

    @JsonProperty("time slot")
    private TimeSlotDto timeSlot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShortDoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(ShortDoctorDto doctor) {
        this.doctor = doctor;
    }

    public TimeSlotDto getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlotDto timeSlot) {
        this.timeSlot = timeSlot;
    }
}
