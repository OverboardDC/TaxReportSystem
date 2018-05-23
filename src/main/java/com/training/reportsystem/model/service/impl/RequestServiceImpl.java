package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public class RequestServiceImpl implements RequestService {

    @Override
    public List<Request> findAll() {
        return DaoFactory.getInstance().createRequestDao().findAll();
    }

    @Override
    public Request getById(Long id) {
        return DaoFactory.getInstance().createRequestDao().getById(id);
    }

    @Override
    public void create(Request request) {
        DaoFactory.getInstance().createRequestDao().create(request);
    }

    @Override
    public void update(Request request) {
        DaoFactory.getInstance().createRequestDao().update(request);
    }

    @Override
    public void delete(Long id) {
        DaoFactory.getInstance().createRequestDao().delete(id);
    }

    @Override
    public List<Request> findByTaxPayerId(Long taxPayerId, Pagination pagination) {
        return DaoFactory.getInstance().createRequestDao().findByTaxPayerId(taxPayerId, pagination);
    }

    @Override
    public List<Request> findByStatus(Status status, Pagination pagination) {
        return DaoFactory.getInstance().createRequestDao().findByStatus(status, pagination);
    }

    @Override
    public void accept(Long requestId, Long taxPayerId, Long inspectorId) {
        DaoFactory.getInstance().createRequestDao().accept(requestId, taxPayerId, inspectorId);
    }

    @Override
    public void reject(Long requestId, String rejectReason) {
        DaoFactory.getInstance().createRequestDao().reject(requestId, rejectReason);
    }

    @Override
    public boolean areThereRequestsWithStatus(Status status, Long taxPayerId) {
        return DaoFactory.getInstance().createRequestDao().areThereRequestsWithStatus(status, taxPayerId);
    }

}
