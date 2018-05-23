package com.training.reportsystem.model.dao.factory;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.impl.InspectorDaoImpl;
import com.training.reportsystem.model.dao.impl.ReportDaoImpl;
import com.training.reportsystem.model.dao.impl.RequestDaoImpl;
import com.training.reportsystem.model.dao.impl.TaxPayerDaoImpl;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public InspectorDao createInspectorDao() {
        return new InspectorDaoImpl();
    }

    @Override
    public TaxPayerDao createTaxPayerDao() {
        return new TaxPayerDaoImpl();
    }

    @Override
    public ReportDao createReportDao() {
        return new ReportDaoImpl();
    }

    @Override
    public RequestDao createRequestDao() {
        return new RequestDaoImpl();
    }
}
