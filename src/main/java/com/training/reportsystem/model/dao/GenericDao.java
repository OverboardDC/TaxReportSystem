package com.training.reportsystem.model.dao;

import org.apache.log4j.Logger;

import java.util.List;

public interface GenericDao<T> {

    Logger logger = Logger.getRootLogger();

    List<T> findAll();

    T getById(Long id);

    void create(T t);

    void update(Long id);

    void delete(Long id);
}
