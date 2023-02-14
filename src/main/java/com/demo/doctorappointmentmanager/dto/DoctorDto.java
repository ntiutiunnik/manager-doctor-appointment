package com.demo.doctorappointmentmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorDto {

    private Long id;

    @JsonProperty("first name")
    private String firstName;

    @JsonProperty("last name")
    private String lastName;

    @JsonProperty("years of experience")
    private Integer experienceYears;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }
}
