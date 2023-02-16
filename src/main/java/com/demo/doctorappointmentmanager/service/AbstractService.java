package com.demo.doctorappointmentmanager.service;

import com.demo.doctorappointmentmanager.dto.BasicDto;
import com.demo.doctorappointmentmanager.exception.CustomCrudException;
import com.demo.doctorappointmentmanager.exception.ResourceNotFoundException;
import com.demo.doctorappointmentmanager.mapper.AbstractMapper;
import com.demo.doctorappointmentmanager.model.BasicEntity;
import com.demo.doctorappointmentmanager.util.OffsetLimitPageable;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends BasicEntity<ID>, ID, DTO extends BasicDto<ID>, M extends AbstractMapper<T, DTO>, R extends JpaRepository<T, ID>> {

    protected final M mapper;

    protected final R repository;

    protected final EntityManager entityManager;

    protected AbstractService(M mapper, R repository, EntityManager entityManager) {
        this.mapper = mapper;
        this.repository = repository;
        this.entityManager = entityManager;
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

        T entity = repository.saveAndFlush(mapper.dtoToEntity(dto));
        entityManager.refresh(entity);

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
