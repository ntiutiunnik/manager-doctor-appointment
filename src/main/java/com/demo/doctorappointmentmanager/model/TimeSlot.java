package com.demo.doctorappointmentmanager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeslot_id_generator")
    @SequenceGenerator(name = "timeslot_id_generator", sequenceName = "timeslot_id_seq", allocationSize = 1)
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @OneToMany(mappedBy = "timeSlot")
    private List<DoctorSchedule> doctorScheduleList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(id, timeSlot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<DoctorSchedule> getDoctorScheduleList() {
        return doctorScheduleList;
    }

    public void setDoctorScheduleList(List<DoctorSchedule> doctorScheduleList) {
        this.doctorScheduleList = doctorScheduleList;
    }
}
