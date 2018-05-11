package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.impl.InspectorDaoImpl;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class InspectorServiceImpl implements InspectorService {

    private InspectorDao inspectorDao;

    public InspectorServiceImpl() {
        inspectorDao = new InspectorDaoImpl();
    }


    @Override
    public Inspector login(String username, String password) {
        return inspectorDao.login(username, Md5Encryptor.encrypt(password));
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return inspectorDao.isUsernameUnique(username);
    }

    @Override
    public List<Inspector> findAll() {
        return inspectorDao.findAll();
    }

    @Override
    public Inspector getById(Long id) {
        return inspectorDao.getById(id);
    }

    @Override
    public void create(Inspector inspector) {
        inspectorDao.create(inspector);
    }

    @Override
    public void update(Inspector t) {
        inspectorDao.update(t);
    }

    @Override
    public void delete(Long id) {
        inspectorDao.delete(id);
    }

    @Override
    public Inspector getByUserId(Long userId) {
        return inspectorDao.getByUserId(userId);
    }
}
