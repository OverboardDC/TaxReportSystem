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

    /**
     *
     * @param username username
     * @param password password
     * @return the taxpayer according to parameters
     */
    @Override
    public TaxPayer login(String username, String password) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.login(username, Md5Encryptor.encrypt(password));
        }
    }

    /**
     *
     * @param username username
     * @return is username unique
     */
    @Override
    public boolean isUsernameUnique(String username) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.isUsernameUnique(username);
        }
    }

    /**
     *
     * @return all requests
     */
    @Override
    public List<TaxPayer> findAll() {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.findAll();
        }
    }

    /**
     *
     * @param id tax payer id
     * @return tax payer by id
     */
    @Override
    public TaxPayer getById(Long id) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.getById(id);
        }
    }

    /**
     * Creates a new tax payer
     *
     * @param taxPayer tax payer
     */
    @Override
    public void create(TaxPayer taxPayer) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.create(taxPayer);
        }
    }

    /**
     * Updates the tax payer
     *
     * @param taxPayer tax payer
     */
    @Override
    public void update(TaxPayer taxPayer) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.update(taxPayer);
        }
    }

    /**
     * Removes the tax payer
     *
     * @param id tax payer id
     */
    @Override
    public void delete(Long id) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.delete(id);
        }
    }

    /**
     *
     * @param pagination pagination
     * @return all tax payers without inspector
     */
    @Override
    public List<TaxPayer> findAllWithoutInspector(Pagination pagination) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            return taxPayerDao.findAllWithoutInspector(pagination);
        }
    }

    /**
     * Assigns the inspector to the tax payer
     *
     * @param taxPayer_id tax payer id
     * @param inspectorId inspector id
     */
    @Override
    public void assignInspector(Long taxPayer_id, Long inspectorId) {
        try(TaxPayerDao taxPayerDao = daoFactory.createTaxPayerDao(ConnectionPool.getConnection())) {
            taxPayerDao.assignInspector(taxPayer_id, inspectorId);
        }
    }
}
