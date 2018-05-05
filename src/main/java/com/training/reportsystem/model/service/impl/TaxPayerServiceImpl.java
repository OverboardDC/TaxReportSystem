package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.impl.TaxPayerDaoImpl;
import com.training.reportsystem.model.entity.user.TaxPayer;
import com.training.reportsystem.model.entity.user.User;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class TaxPayerServiceImpl implements TaxPayerService {

    private TaxPayerDao taxPayerDao;

    public TaxPayerServiceImpl() {
        taxPayerDao = new TaxPayerDaoImpl();
    }


    @Override
    public TaxPayer login(String username, String password) {
        return taxPayerDao.login(username, Md5Encryptor.encrypt(password));
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return taxPayerDao.isUsernameUnique(username);
    }

    @Override
    public List<TaxPayer> findAll() {
        return taxPayerDao.findAll();
    }

    @Override
    public TaxPayer getById(Long id) {
        return taxPayerDao.getById(id);
    }

    @Override
    public void create(TaxPayer taxPayer) {
        taxPayerDao.create(taxPayer);
    }

    @Override
    public void update(Long id) {
        taxPayerDao.update(id);
    }

    @Override
    public void delete(Long id) {
        taxPayerDao.delete(id);
    }
}
