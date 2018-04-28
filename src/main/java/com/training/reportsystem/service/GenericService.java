package com.training.reportsystem.service;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();

    T getById(Long id);

    void add(T t);

    void remove(Long id);

    void edit(Long id);

}
