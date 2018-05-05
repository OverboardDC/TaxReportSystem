package com.training.reportsystem.model.dao;

import java.util.List;

public interface GenericDao<T> {

    List<T> findAll();

    T getById(Long id);

    void create(T t);

    void update(Long id);

    void delete(Long id);
}
