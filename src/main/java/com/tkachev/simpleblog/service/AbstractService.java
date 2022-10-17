package com.tkachev.simpleblog.service;

import com.tkachev.simpleblog.exception_handling.exceptions.NoSuchEntityException;

public abstract class AbstractService<ID> {
    public <T> T isNotNull(T entity, String entityName, ID id) {
        if (entity == null) {
            throw new NoSuchEntityException(String.format("No %s with ID = %s exists!", entityName, id));
        }

        return entity;
    }
}
