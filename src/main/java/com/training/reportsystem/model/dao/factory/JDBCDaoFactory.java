package com.training.reportsystem.model.dao.factory;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.impl.InspectorDaoImpl;
import com.training.reportsystem.model.dao.impl.ReportDaoImpl;
import com.training.reportsystem.model.dao.impl.RequestDaoImpl;
import com.training.reportsystem.model.dao.impl.TaxPayerDaoImpl;

import java.sql.Connection;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public InspectorDao createInspectorDao(Connection connection) {
        return new InspectorDaoImpl(connection);
    }

    @Override
    public TaxPayerDao createTaxPayerDao(Connection connection) {
        return new TaxPayerDaoImpl(connection);
    }

    @Override
    public ReportDao createReportDao(Connection connection) {
        return new ReportDaoImpl(connection);
    }

    @Override
    public RequestDao createRequestDao(Connection connection) {
        return new RequestDaoImpl(connection);
    }
}
