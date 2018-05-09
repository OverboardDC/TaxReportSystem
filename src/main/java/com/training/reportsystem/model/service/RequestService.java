package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.Request;

import java.util.List;

public interface RequestService extends GenericService<Request> {

    List<Request> findByTaxPayerId(Long taxPayerId);

    List<Request> findByStatus(Status status);

    void accept(Long requestId);

    void reject(Long requestId, String rejectReason);
}
