package com.training.reportsystem.model.service;

import java.util.List;

//TODO fix update bag
public interface GenericService<T> {

    List<T> findAll();

    T getById(Long id);

    void create(T t);

    void update(Long id);

    void delete(Long id);

}
