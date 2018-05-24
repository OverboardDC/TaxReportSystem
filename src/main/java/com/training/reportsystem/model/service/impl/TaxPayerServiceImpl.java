package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.Md5Encryptor;

import java.util.List;

public class TaxPayerServiceImpl implements TaxPayerService {

    @Override
    public TaxPayer login(String username, String password) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            return taxPayerDao.login(username, Md5Encryptor.encrypt(password));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isUsernameUnique(String username) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            return taxPayerDao.isUsernameUnique(username);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<TaxPayer> findAll() {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            return taxPayerDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public TaxPayer getById(Long id) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            return taxPayerDao.getById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void create(TaxPayer taxPayer) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            taxPayerDao.create(taxPayer);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(TaxPayer taxPayer) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            taxPayerDao.update(taxPayer);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Long id) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            taxPayerDao.delete(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<TaxPayer> findAllWithoutInspector(Pagination pagination) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            return taxPayerDao.findAllWithoutInspector(pagination);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void assignInspector(Long taxPayer_id, Long inspectorId) {
        try(TaxPayerDao taxPayerDao = DaoFactory.getInstance().createTaxPayerDao()) {
            taxPayerDao.assignInspector(taxPayer_id, inspectorId);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
