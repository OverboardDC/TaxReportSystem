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

    /**
     *
     * @param username username
     * @param password password
     * @return the inspector according to parameters
     */
    @Override
    public Inspector login(String username, String password) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.login(username, Md5Encryptor.encrypt(password));
        }
    }

    /**
     *
     * @param username username
     * @return is username unique
     */
    @Override
    public boolean isUsernameUnique(String username) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.isUsernameUnique(username);
        }
    }

    /**
     *
     * @return all inspectors
     */
    @Override
    public List<Inspector> findAll() {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.findAll();
        }
    }

    /**
     *
     * @param id inspector id
     * @return inspector by id
     */
    @Override
    public Inspector getById(Long id) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.getByUserId(id);
        }
    }

    /**
     * Creates a new inspector
     *
     * @param inspector inspector
     */
    @Override
    public void create(Inspector inspector) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            inspectorDao.create(inspector);
        }
    }

    /**
     * Updates the inspector
     *
     * @param inspector inspector
     */
    @Override
    public void update(Inspector inspector) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            inspectorDao.update(inspector);
        }
    }

    /**
     * Removes the inspector by id
     *
     * @param id inspector id
     */
    @Override
    public void delete(Long id) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            inspectorDao.delete(id);
        }
    }

    /**
     *
     * @param userId user id
     * @return inspector by user id
     */
    @Override
    public Inspector getByUserId(Long userId) {
        try(InspectorDao inspectorDao = daoFactory.createInspectorDao(ConnectionPool.getConnection())) {
            return inspectorDao.getByUserId(userId);
        }
    }
}
