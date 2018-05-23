package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class TaxPayerServiceImpl implements TaxPayerService {

    @Override
    public TaxPayer login(String username, String password) {
        return DaoFactory.getInstance().createTaxPayerDao().login(username, Md5Encryptor.encrypt(password));
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return DaoFactory.getInstance().createTaxPayerDao().isUsernameUnique(username);
    }

    @Override
    public List<TaxPayer> findAll() {
        return DaoFactory.getInstance().createTaxPayerDao().findAll();
    }

    @Override
    public TaxPayer getById(Long id) {
        return DaoFactory.getInstance().createTaxPayerDao().getById(id);
    }

    @Override
    public void create(TaxPayer taxPayer) {
        DaoFactory.getInstance().createTaxPayerDao().create(taxPayer);
    }

    @Override
    public void update(TaxPayer taxPayer) {
        DaoFactory.getInstance().createTaxPayerDao().update(taxPayer);
    }

    @Override
    public void delete(Long id) {
        DaoFactory.getInstance().createTaxPayerDao().delete(id);
    }

    @Override
    public List<TaxPayer> findAllWithoutInspector(Pagination pagination) {
        return DaoFactory.getInstance().createTaxPayerDao().findAllWithoutInspector(pagination);
    }

    @Override
    public void assignInspector(Long taxPayer_id, Long inspectorId) {
        DaoFactory.getInstance().createTaxPayerDao().assignInspector(taxPayer_id, inspectorId);
    }
}
