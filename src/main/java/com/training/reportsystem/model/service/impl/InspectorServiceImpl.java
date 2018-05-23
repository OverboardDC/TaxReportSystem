package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class InspectorServiceImpl implements InspectorService {

    @Override
    public Inspector login(String username, String password) {
        return DaoFactory.getInstance().createInspectorDao().login(username, Md5Encryptor.encrypt(password));
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return DaoFactory.getInstance().createInspectorDao().isUsernameUnique(username);
    }

    @Override
    public List<Inspector> findAll() {
        return DaoFactory.getInstance().createInspectorDao().findAll();
    }

    @Override
    public Inspector getById(Long id) {
        return DaoFactory.getInstance().createInspectorDao().getByUserId(id);
    }

    @Override
    public void create(Inspector inspector) {
        DaoFactory.getInstance().createInspectorDao().create(inspector);
    }

    @Override
    public void update(Inspector inspector) {
        DaoFactory.getInstance().createInspectorDao().update(inspector);
    }

    @Override
    public void delete(Long id) {
        DaoFactory.getInstance().createInspectorDao().delete(id);

    }

    @Override
    public Inspector getByUserId(Long userId) {
        return DaoFactory.getInstance().createInspectorDao().getByUserId(userId);
    }
}
