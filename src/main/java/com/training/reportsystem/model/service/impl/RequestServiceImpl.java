package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.impl.RequestDaoImpl;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.Request;
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
    public void update(Request t) {
        requestDao.update(t);
    }

    @Override
    public void delete(Long id) {
        requestDao.delete(id);
    }

    @Override
    public List<Request> findByTaxPayerId(Long taxPayerId) {
        return requestDao.findByTaxPayerId(taxPayerId);
    }

    @Override
    public List<Request> findByStatus(Status status) {
        return requestDao.findByStatus(status);
    }

    @Override
    public void accept(Long requestId, Long taxPayerId, Long inspectorId) {
        requestDao.accept(requestId, taxPayerId, inspectorId);
    }

    @Override
    public void reject(Long requestId, String rejectReason) {
        requestDao.reject(requestId, rejectReason);
    }

}
