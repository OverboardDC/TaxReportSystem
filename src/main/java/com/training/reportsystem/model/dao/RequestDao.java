package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public interface RequestDao extends GenericDao<Request> {

    List<Request> findByTaxPayerId(Long taxPayerId, Pagination pagination);

    List<Request> findByStatus(Status status, Pagination pagination);

    void accept(Long requestId, Long taxPayerId, Long inspectorId);

    void reject(Long requestId, String rejectReason);

}
