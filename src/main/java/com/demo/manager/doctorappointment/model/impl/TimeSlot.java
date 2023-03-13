package com.demo.manager.doctorappointment.model.impl;

import com.demo.manager.doctorappointment.model.BasicEntity;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TimeSlot implements BasicEntity<TimeSlot, Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time_slot_id_generator")
    @SequenceGenerator(name = "time_slot_id_generator", sequenceName = "time_slot_id_seq", allocationSize = 1)
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

    @Override
    public Class<? extends TimeSlot> getEntityClass() {
        return getClass();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
