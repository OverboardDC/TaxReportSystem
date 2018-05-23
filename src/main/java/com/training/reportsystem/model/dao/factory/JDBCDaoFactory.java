package com.training.reportsystem.model.dao.factory;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.impl.InspectorDaoImpl;
import com.training.reportsystem.model.dao.impl.ReportDaoImpl;
import com.training.reportsystem.model.dao.impl.RequestDaoImpl;
import com.training.reportsystem.model.dao.impl.TaxPayerDaoImpl;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.util.constants.LoggerMessages;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private static Logger logger = Logger.getRootLogger();

    @Override
    public InspectorDao createInspectorDao() {
        return new InspectorDaoImpl(getConnection());
    }

    @Override
    public TaxPayerDao createTaxPayerDao() {
        return new TaxPayerDaoImpl(getConnection());
    }

    @Override
    public ReportDao createReportDao() {
        return new ReportDaoImpl(getConnection());
    }

    @Override
    public RequestDao createRequestDao() {
        return new RequestDaoImpl(getConnection());
    }

    private static Connection getConnection(){
        try {
            return ConnectionPool.getConnection();
        } catch (SQLException e) {
            logger.error(LoggerMessages.CONNECTION_FAILED);
            throw new RuntimeException();
        }
    }
}
