package com.training.reportsystem.model.dao.factory;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.TaxPayerDao;

import java.sql.Connection;

public abstract class DaoFactory {

    private static DaoFactory instance;

    public abstract InspectorDao createInspectorDao(Connection connection);

    public abstract TaxPayerDao createTaxPayerDao(Connection connection);

    public abstract ReportDao createReportDao(Connection connection);

    public abstract RequestDao createRequestDao(Connection connection);

    public static DaoFactory getInstance() {
        if (instance == null) {
            synchronized (DaoFactory.class) {
                if (instance == null) {
                    instance = new JDBCDaoFactory();
                }
            }
        }
        return instance;
    }
}
