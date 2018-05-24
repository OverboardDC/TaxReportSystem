package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class InspectorServiceImpl implements InspectorService {

    @Override
    public Inspector login(String username, String password) {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            return inspectorDao.login(username, Md5Encryptor.encrypt(password));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isUsernameUnique(String username) {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            return inspectorDao.isUsernameUnique(username);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Inspector> findAll() {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            return inspectorDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Inspector getById(Long id) {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            return inspectorDao.getByUserId(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void create(Inspector inspector) {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            inspectorDao.create(inspector);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Inspector inspector) {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            inspectorDao.update(inspector);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Long id) {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            inspectorDao.delete(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Inspector getByUserId(Long userId) {
        try(InspectorDao inspectorDao = DaoFactory.getInstance().createInspectorDao()) {
            return inspectorDao.getByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
