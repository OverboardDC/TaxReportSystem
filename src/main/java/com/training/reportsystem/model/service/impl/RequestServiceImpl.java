package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public class RequestServiceImpl implements RequestService {

    @Override
    public List<Request> findAll() {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            return requestDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Request getById(Long id) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            return requestDao.getById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void create(Request request) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            requestDao.create(request);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Request request) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            requestDao.update(request);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Long id) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            requestDao.delete(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Request> findByTaxPayerId(Long taxPayerId, Pagination pagination) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            return requestDao.findByTaxPayerId(taxPayerId, pagination);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Request> findByStatus(Status status, Pagination pagination) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            return requestDao.findByStatus(status, pagination);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void accept(Long requestId, Long taxPayerId, Long inspectorId) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            requestDao.accept(requestId, taxPayerId, inspectorId);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void reject(Long requestId, String rejectReason) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            requestDao.reject(requestId, rejectReason);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean areThereRequestsWithStatus(Status status, Long taxPayerId) {
        try(RequestDao requestDao = DaoFactory.getInstance().createRequestDao()) {
            return requestDao.areThereRequestsWithStatus(status, taxPayerId);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
