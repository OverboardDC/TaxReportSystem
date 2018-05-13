package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public interface TaxPayerService extends UserService<TaxPayer> {

    List<TaxPayer> findAllWithoutInspector(Pagination pagination);

    void assignInspector(Long taxPayer_id, Long inspectorId);
}
