package com.demo.doctorappointmentmanager.specification;

import com.demo.doctorappointmentmanager.model.DoctorSchedule;
import com.demo.doctorappointmentmanager.specification.filter.DoctorScheduleFilterParam;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DoctorScheduleSpecification {
    public static Specification<DoctorSchedule> getFilteredDoctorSchedules(DoctorScheduleFilterParam params) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Long doctorId = params.getDoctorId();
            if (doctorId != null) {
                predicates.add(criteriaBuilder.equal(root.get("doctor").<Long> get("id"), doctorId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}