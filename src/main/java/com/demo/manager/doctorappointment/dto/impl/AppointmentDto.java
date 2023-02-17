package com.demo.manager.doctorappointment.dto.impl;

import com.demo.manager.doctorappointment.dto.BasicDto;
import com.demo.manager.doctorappointment.dto.shortened.ShortAccountDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AppointmentDto implements BasicDto<Long> {

    private Long id;

    private Long number;

    @JsonProperty("doctor schedule")
    private DoctorScheduleDto doctorSchedule;

    private ShortAccountDto account;

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

    public DoctorScheduleDto getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(DoctorScheduleDto doctorScheduleDto) {
        this.doctorSchedule = doctorScheduleDto;
    }

    public ShortAccountDto getAccount() {
        return account;
    }

    public void setAccount(ShortAccountDto accountDto) {
        this.account = accountDto;
    }
}
