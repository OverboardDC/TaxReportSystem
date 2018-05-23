package com.training.reportsystem.model.dao.factory;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.TaxPayerDao;

public abstract class DaoFactory {

    private static DaoFactory instance;

    public abstract InspectorDao createInspectorDao();

    public abstract TaxPayerDao createTaxPayerDao();

    public abstract ReportDao createReportDao();

    public abstract RequestDao createRequestDao();

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
