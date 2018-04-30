package com.training.reportsystem.service;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();

    T getById(Long id);

    void create(T t);

    void update(Long id);

    void delete(Long id);

}
