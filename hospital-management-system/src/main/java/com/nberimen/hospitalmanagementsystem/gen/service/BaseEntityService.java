package com.nberimen.hospitalmanagementsystem.gen.service;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseAdditionalFields;
import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

    private final R repository;

    public List<E> findAll() {
        return repository.findAll();
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public E getById(Long id) {

        Optional<E> entityOptional = findById(id);

        E entity;
        if (entityOptional.isPresent()) {
            entity = entityOptional.get();
        } else {
            throw new RuntimeException(); //TODO GenErrorException
        }
        return entity;

    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public R getRepository() {
        return repository;
    }

}
