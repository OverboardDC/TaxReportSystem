package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.user.Request;

import java.util.List;

public interface RequestDao extends GenericDao<Request> {

    List<Request> findByTaxPayerId(Long taxPayerId);

    List<Request> findByStatus(Status status);

    void accept(Long requestId);

}
