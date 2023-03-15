package com.demo.manager.doctorappointment.specification;

import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationUtils<T, F extends FilterParam> {

    Specification<T> createSpecification(F filterParam);
}
