package com.springrest.springrest.Data.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@org.springframework.stereotype.Repository
public class RepositoryBean<TEntity, ID extends Serializable> implements Repository<TEntity, ID> {

    @Autowired
    private JpaRepository<TEntity, ID> repository;

    @Override
    public TEntity Get(ID id) {
        return repository.findById(id).orElseThrow(); }

    public List<TEntity> All() {
        return repository.findAll();
    }

    @Override
    public List<TEntity> All(Predicate<TEntity> predicate) {
        return repository.findAll()
                .stream()
                .filter(predicate)
                .toList();
    }

    @Override
    public TEntity save(TEntity entity) {

        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {

        repository.deleteById(id);

    }
}
