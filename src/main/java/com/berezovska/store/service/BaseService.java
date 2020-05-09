package com.berezovska.store.service;

import com.berezovska.store.model.BaseEntity;

import java.util.List;

public interface BaseService <T extends BaseEntity> {

    /**
     * Get all entities.
     * @return List<T> Entities list.
     **/
    List<T> getAll ();

    /**
     * Get entity where id.
     * @param id Entity id.
     * @return T Entity object.
     **/
    T getById (java.util.UUID id);

    /**
     * Save Entity.
     * @param entity Entity object
     **/
    void save (T entity);

    /**
     * Delete Entity where id.
     * @param id Entity id
     **/
    void delete (java.util.UUID id);

    /**
     * Update entity.
     * @param entity Entity object.
     * @return T Entity object.
     **/
    T update (T entity);


}
