package com.demo.doctorappointmentmanager.service;

import com.demo.doctorappointmentmanager.dto.BasicDto;
import com.demo.doctorappointmentmanager.exception.CustomCrudException;
import com.demo.doctorappointmentmanager.exception.ResourceNotFoundException;
import com.demo.doctorappointmentmanager.mapper.AbstractMapper;
import com.demo.doctorappointmentmanager.util.OffsetLimitPageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, ID, DTO extends BasicDto<ID>, M extends AbstractMapper<T, DTO>, R extends JpaRepository<T, ID>> {

    protected final M mapper;
    protected final R repository;

    protected AbstractService(M mapper, R repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<DTO> findAll(OffsetLimitPageable offsetLimitPageable) {
        Page<T> page = repository.findAll(offsetLimitPageable);
        return mapper.entitiesToDtos(page.getContent());
    }

    public DTO findById(ID id) {
        Optional<T> optionalT = repository.findById(id);
        return optionalT.map(mapper::entityToDto).orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
    }

    public DTO save(DTO dto) {
        if (dto.getId() != null) {
            throw new CustomCrudException("Null id should be specified for creation.");
        }

        T entity = mapper.dtoToEntity(dto);
        return mapper.entityToDto(repository.save(entity));
    }

    public void deleteById(ID id) {
        Optional<T> optionalT = repository.findById(id);
        if (optionalT.isEmpty()) {
            throw new ResourceNotFoundException("Entity not found.");
        }

        repository.deleteById(id);
    }
}
