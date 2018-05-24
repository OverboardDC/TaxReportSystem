package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class InspectorServiceImpl implements InspectorService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Inspector login(String username, String password) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.login(username, Md5Encryptor.encrypt(password));
        }
    }

    @Override
    public boolean isUsernameUnique(String username) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.isUsernameUnique(username);
        }
    }

    @Override
    public List<Inspector> findAll() {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.findAll();
        }
    }

    @Override
    public Inspector getById(Long id) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.getByUserId(id);
        }
    }

    @Override
    public void create(Inspector inspector) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            inspectorDao.create(inspector);
        }
    }

    @Override
    public void update(Inspector inspector) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            inspectorDao.update(inspector);
        }
    }

    @Override
    public void delete(Long id) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            inspectorDao.delete(id);
        }
    }

    @Override
    public Inspector getByUserId(Long userId) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.getByUserId(userId);
        }
    }
}
