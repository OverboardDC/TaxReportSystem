package com.training.reportsystem.model.service.impl.hibernate;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.impl.hibernate.RequestDaoHibernate;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/17/2018.
 */
@Service
public class RequestServiceHibernate implements RequestService {

    private RequestDao requestDao;

    @Override
    public void create(Request request) {
        requestDao.create(request);
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

    @Override
    public boolean areThereRequestsWithStatus(Status status, Long taxPayerId) {
        return requestDao.areThereRequestsWithStatus(status, taxPayerId);
    }

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }
}
