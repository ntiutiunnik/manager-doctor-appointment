package com.demo.doctorappointmentmanager.dto.impl;

import com.demo.doctorappointmentmanager.dto.BasicDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AppointmentDto implements BasicDto<Long> {

    private Long id;

    private Long number;

    @JsonProperty("doctor schedule")
    private DoctorScheduleDto doctorScheduleDto;

    @JsonProperty("user")
    private UserDto userDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public DoctorScheduleDto getDoctorScheduleDto() {
        return doctorScheduleDto;
    }

    public void setDoctorScheduleDto(DoctorScheduleDto doctorScheduleDto) {
        this.doctorScheduleDto = doctorScheduleDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
