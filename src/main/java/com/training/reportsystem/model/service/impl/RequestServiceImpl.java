package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public class RequestServiceImpl implements RequestService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Request> findAll() {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.findAll();
        }
    }

    @Override
    public Request getById(Long id) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.getById(id);
        }
    }

    @Override
    public void create(Request request) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.create(request);
        }
    }

    @Override
    public void update(Request request) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.update(request);
        }
    }

    @Override
    public void delete(Long id) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.delete(id);
        }
    }

    @Override
    public List<Request> findByTaxPayerId(Long taxPayerId, Pagination pagination) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.findByTaxPayerId(taxPayerId, pagination);
        }
    }

    @Override
    public List<Request> findByStatus(Status status, Pagination pagination) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.findByStatus(status, pagination);
        }
    }

    @Override
    public void accept(Long requestId, Long taxPayerId, Long inspectorId) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.accept(requestId, taxPayerId, inspectorId);
        }
    }

    @Override
    public void reject(Long requestId, String rejectReason) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.reject(requestId, rejectReason);
        }
    }

    @Override
    public boolean areThereRequestsWithStatus(Status status, Long taxPayerId) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.areThereRequestsWithStatus(status, taxPayerId);
        }
    }

}
