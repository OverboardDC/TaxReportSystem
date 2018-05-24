package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class TaxPayerServiceImpl implements TaxPayerService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public TaxPayer login(String username, String password) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.login(username, Md5Encryptor.encrypt(password));
        }
    }

    @Override
    public boolean isUsernameUnique(String username) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.isUsernameUnique(username);
        }
    }

    @Override
    public List<TaxPayer> findAll() {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.findAll();
        }
    }

    @Override
    public TaxPayer getById(Long id) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.getById(id);
        }
    }

    @Override
    public void create(TaxPayer taxPayer) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.create(taxPayer);
        }
    }

    @Override
    public void update(TaxPayer taxPayer) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.update(taxPayer);
        }
    }

    @Override
    public void delete(Long id) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.delete(id);
        }
    }

    @Override
    public List<TaxPayer> findAllWithoutInspector(Pagination pagination) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.findAllWithoutInspector(pagination);
        }
    }

    @Override
    public void assignInspector(Long taxPayer_id, Long inspectorId) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.assignInspector(taxPayer_id, inspectorId);
        }
    }
}
