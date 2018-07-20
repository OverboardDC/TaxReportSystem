package com.training.reportsystem.model.service.impl.hibernate;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.impl.hibernate.TaxPayerDaoHibernate;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.TaxPayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/17/2018.
 */
@Service
public class TaxPayerServiceHibernate implements TaxPayerService {

    private TaxPayerDao taxPayerDao;

    @Override
    public void create(TaxPayer taxPayer) {
        taxPayerDao.create(taxPayer);
    }

    @Override
    public List<TaxPayer> findAllWithoutInspector() {
        return taxPayerDao.findAllWithoutInspector();
    }

    @Override
    public void assignInspector(Long taxPayer_id, Long inspectorId) {
        taxPayerDao.assignInspector(taxPayer_id, inspectorId);
    }

    @Autowired
    public void setTaxPayerDao(TaxPayerDao taxPayerDao) {
        this.taxPayerDao = taxPayerDao;
    }
}
