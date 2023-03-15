package com.demo.manager.doctorappointment.service;

import com.demo.manager.doctorappointment.specification.filter.FilterParam;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PagingAndFilteringCrudService<DTO, ID, F extends FilterParam> extends CrudService<DTO, ID> {

    List<DTO> findAll(Pageable pageable, F filterParam);
}
