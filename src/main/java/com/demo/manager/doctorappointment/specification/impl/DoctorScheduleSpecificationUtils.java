package com.demo.manager.doctorappointment.specification.impl;

import com.demo.manager.doctorappointment.model.impl.DoctorSchedule;
import com.demo.manager.doctorappointment.specification.SpecificationUtils;
import com.demo.manager.doctorappointment.specification.filter.impl.DoctorScheduleFilterParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorScheduleSpecificationUtils implements SpecificationUtils<DoctorSchedule, DoctorScheduleFilterParam> {

    public Specification<DoctorSchedule> createSpecification(DoctorScheduleFilterParam params) {
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