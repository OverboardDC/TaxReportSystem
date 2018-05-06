package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.user.TaxPayer;

import java.util.List;

public interface TaxPayerDao extends UserDao<TaxPayer> {

    List<TaxPayer> findAllWithoutInspector();

}
