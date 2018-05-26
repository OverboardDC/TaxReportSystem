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

    /**
     *
     * @return all requests
     */
    @Override
    public List<Request> findAll() {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.findAll();
        }
    }

    /**
     *
     * @param id request id
     * @return request by id
     */
    @Override
    public Request getById(Long id) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.getById(id);
        }
    }

    /**
     * Creates a new request
     *
     * @param request request
     */
    @Override
    public void create(Request request) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.create(request);
        }
    }

    /**
     * Updates the request
     *
     * @param request request
     */
    @Override
    public void update(Request request) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.update(request);
        }
    }

    /**
     * Removes the request
     *
     * @param id request id
     */
    @Override
    public void delete(Long id) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.delete(id);
        }
    }

    /**
     *
     * @param taxPayerId tax payer id
     * @param pagination pagination
     * @return all request by tax payer id
     */
    @Override
    public List<Request> findByTaxPayerId(Long taxPayerId, Pagination pagination) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.findByTaxPayerId(taxPayerId, pagination);
        }
    }

    /**
     *
     * @param status status
     * @param pagination pagination
     * @return all requests by status
     */
    @Override
    public List<Request> findByStatus(Status status, Pagination pagination) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.findByStatus(status, pagination);
        }
    }

    /**
     * Accepts the request
     *
     * @param requestId request id
     * @param taxPayerId tax payer id
     * @param inspectorId inspector id
     */
    @Override
    public void accept(Long requestId, Long taxPayerId, Long inspectorId) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.accept(requestId, taxPayerId, inspectorId);
        }
    }

    /**
     * Rejects the request
     *
     * @param requestId request id
     * @param rejectReason reject reason
     */
    @Override
    public void reject(Long requestId, String rejectReason) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            requestDao.reject(requestId, rejectReason);
        }
    }

    /**
     *
     * @param status status
     * @param taxPayerId tax payer id
     * @return are there request with status
     */
    @Override
    public boolean areThereRequestsWithStatus(Status status, Long taxPayerId) {
        try(RequestDao requestDao = daoFactory.createRequestDao(ConnectionPool.getConnection())) {
            return requestDao.areThereRequestsWithStatus(status, taxPayerId);
        }
    }

}
