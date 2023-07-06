package com.springrest.springrest.Data.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<TEntity, ID extends Serializable> {

    TEntity Get(ID id);

    List<TEntity> All();

    List<TEntity> All(Predicate<TEntity> predicate);

    TEntity save(TEntity entity);

    void delete(ID id);

}

