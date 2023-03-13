package com.demo.manager.doctorappointment.specification;

import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import com.demo.manager.doctorappointment.specification.filter.DoctorScheduleFilterParam;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class DoctorScheduleSpecification {

    private DoctorScheduleSpecification() {
        throw new IllegalStateException("Utility class");
    }

    public static Specification<DoctorSchedule> getFilteredDoctorSchedules(DoctorScheduleFilterParam params) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Long doctorId = params.getDoctorId();
            if (doctorId != null) {
                predicates.add(criteriaBuilder.equal(root.get("doctor").<Long> get("id"), doctorId));
            }

            Long timeSlotId = params.getTimeSlotId();
            if (timeSlotId != null) {
                predicates.add(criteriaBuilder.equal(root.get("timeSlot").<Long> get("id"), timeSlotId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}