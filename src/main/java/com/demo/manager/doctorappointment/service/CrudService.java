package com.demo.manager.doctorappointment.service;

import com.github.fge.jsonpatch.JsonPatch;

public interface CrudService<DTO, ID> {

    DTO findById(ID id);

    DTO save(DTO entity);

    DTO update(ID id, JsonPatch patch);

    void deleteById(ID id);
}
