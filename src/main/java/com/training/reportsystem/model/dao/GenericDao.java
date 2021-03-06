package com.training.reportsystem.model.dao;

import org.apache.log4j.Logger;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable{

    Logger logger = Logger.getRootLogger();

    List<T> findAll();

    T getById(Long id);

    void create(T t);

    void update(T t);

    void delete(Long id);

    void close();
}
