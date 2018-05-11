package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.TaxPayer;

import java.util.List;

public interface TaxPayerService extends UserService<TaxPayer> {

    List<TaxPayer> findAllWithoutInspector();

    void assignInspector(Long taxPayer_id, Long inspectorId);
}
