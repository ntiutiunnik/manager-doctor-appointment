package com.demo.manager.doctorappointment.service;

import com.demo.manager.doctorappointment.dto.BasicDto;
import com.demo.manager.doctorappointment.exception.CustomCrudException;
import com.demo.manager.doctorappointment.exception.ResourceNotFoundException;
import com.demo.manager.doctorappointment.mapper.AbstractMapper;
import com.demo.manager.doctorappointment.model.BasicEntity;
import com.demo.manager.doctorappointment.repository.CustomTransactionalRepository;
import com.demo.manager.doctorappointment.util.OffsetLimitPageable;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends BasicEntity<ID>, ID, DTO extends BasicDto<ID>, M extends AbstractMapper<T, DTO>, R extends CustomTransactionalRepository<T, ID>> {

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
        return optionalT.map(mapper::entityToDto).
                orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
    }

    @Transactional
    public DTO save(DTO dto) {
        if (dto.getId() != null) {
            throw new CustomCrudException("Null id should be specified for creation.");
        }

        beforeSave(dto);

        T entity = repository.save(mapper.dtoToEntity(dto));

        return findById(entity.getId());
    }

    public void deleteById(ID id) {
        Optional<T> optionalT = repository.findById(id);
        if (optionalT.isEmpty()) {
            throw new ResourceNotFoundException("Entity not found.");
        }

        repository.deleteById(id);
    }

    protected void beforeSave(DTO dto) {
    }
}
