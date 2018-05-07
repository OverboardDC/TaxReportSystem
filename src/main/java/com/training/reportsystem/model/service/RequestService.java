package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.user.Request;

import java.util.List;

public interface RequestService extends GenericService<Request> {

    List<Request> findByTaxPayerId(Long taxPayerId);
}
