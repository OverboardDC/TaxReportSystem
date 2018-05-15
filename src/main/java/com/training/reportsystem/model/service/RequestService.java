package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public interface RequestService extends GenericService<Request> {

    List<Request> findByTaxPayerId(Long taxPayerId, Pagination pagination);

    List<Request> findByStatus(Status status, Pagination pagination);

    void accept(Long requestId, Long taxPayerId, Long inspectorId);

    void reject(Long requestId, String rejectReason);

    boolean areThereRequestsWithStatus(Status status, Long taxPayerId);
}
