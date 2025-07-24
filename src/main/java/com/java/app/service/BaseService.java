package com.java.app.service;

import java.util.List;

public interface BaseService<T> {
    T save(T entity);
    T getById(Long id);

    List<T> getAll();
}
