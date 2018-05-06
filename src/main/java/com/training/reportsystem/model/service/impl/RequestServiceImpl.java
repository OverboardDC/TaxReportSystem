package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.impl.RequestDaoImpl;
import com.training.reportsystem.model.entity.user.Request;
import com.training.reportsystem.model.service.RequestService;

import java.util.List;

public class RequestServiceImpl implements RequestService {

    private RequestDao requestDao;

    public RequestServiceImpl() {
        requestDao = new RequestDaoImpl();
    }

    @Override
    public List<Request> findAll() {
        return requestDao.findAll();
    }

    @Override
    public Request getById(Long id) {
        return requestDao.getById(id);
    }

    @Override
    public void create(Request request) {
        requestDao.create(request);
    }

    @Override
    public void update(Long id) {
        requestDao.update(id);
    }

    @Override
    public void delete(Long id) {
        requestDao.delete(id);
    }
}
