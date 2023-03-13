package com.demo.manager.doctorappointment.service;

import com.demo.manager.doctorappointment.dto.BasicDto;
import com.demo.manager.doctorappointment.exception.CustomCrudException;
import com.demo.manager.doctorappointment.exception.ResourceNotFoundException;
import com.demo.manager.doctorappointment.mapper.AbstractMapper;
import com.demo.manager.doctorappointment.model.BasicEntity;
import com.demo.manager.doctorappointment.repository.CustomTransactionalRepository;
import com.demo.manager.doctorappointment.util.OffsetLimitPageable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends BasicEntity<T, ID>, ID, DTO extends BasicDto<ID>, M extends AbstractMapper<T, DTO>, R extends CustomTransactionalRepository<T, ID>> {

    protected final M mapper;

    protected final R repository;

    protected final ObjectMapper objectMapper;

    protected AbstractService(M mapper,
                              R repository,
                              ObjectMapper objectMapper) {
        this.mapper = mapper;
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public List<DTO> findAll(OffsetLimitPageable offsetLimitPageable) {
        Page<T> page = repository.findAll(offsetLimitPageable);
        return mapper.entitiesToDtos(page.getContent());
    }

    public DTO findById(ID id) {
        T entity = retrieveById(id);
        return mapper.entityToDto(entity);
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

    @Transactional
    public DTO update(ID id, JsonPatch patch) {
        T entity = retrieveById(id);
        entity = repository.save(applyPatch(entity, patch));

        return findById(entity.getId());
    }

    @Transactional
    public void deleteById(ID id) {
        retrieveById(id);
        repository.deleteById(id);
    }

    protected void beforeSave(DTO dto) {
    }

    private T retrieveById(ID id) {
        Optional<T> maybeEntity = repository.findById(id);
        return maybeEntity.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
    }

    private T applyPatch(T entity, JsonPatch patch) {
        try {
            JsonNode patched = patch.apply(objectMapper.convertValue(entity, JsonNode.class));
            return objectMapper.treeToValue(patched, entity.getEntityClass());
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new CustomCrudException("Patch operation unsuccessful: " + e.getMessage());
        }
    }
}
