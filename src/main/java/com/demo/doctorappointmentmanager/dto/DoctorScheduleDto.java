package com.demo.doctorappointmentmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorScheduleDto {

    private Long id;

    @JsonProperty("doctor")
    private DoctorDto doctorDto;

    @JsonProperty("time slot")
    private TimeSlotDto timeSlotDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorDto getDoctorDto() {
        return doctorDto;
    }

    public void setDoctorDto(DoctorDto doctorDto) {
        this.doctorDto = doctorDto;
    }

    public TimeSlotDto getTimeSlotDto() {
        return timeSlotDto;
    }

    public void setTimeSlotDto(TimeSlotDto timeSlotDto) {
        this.timeSlotDto = timeSlotDto;
    }
}
