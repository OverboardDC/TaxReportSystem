package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     *
     * @param userId user id
     * @param pagination pagination
     * @return all reports by user id
     */
    @Override
    public List<Report> findAllByUser(Long userId, Pagination pagination) {
        try (ReportDao reportDao = daoFactory.createReportDao(ConnectionPool.getConnection())) {
            return reportDao.findAllByUser(userId, pagination);
        }
    }

    /**
     *
     * @param inspectorId inspector id
     * @param pagination pagination
     * @return all reports by inspector id
     */
    @Override
    public List<Report> findAllByInspector(Long inspectorId, Pagination pagination) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            return reportDao.findAllByInspector(inspectorId, pagination);
        }
    }

    /**
     * Approves the report
     *
     * @param reportId report id
     */
    @Override
    public void approveReport(Long reportId) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            reportDao.approveReport(reportId);
        }
    }

    /**
     * Rejects the report
     *
     * @param reportId report id
     * @param rejectReason reject reason
     */
    @Override
    public void rejectReport(Long reportId, String rejectReason) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            reportDao.rejectReport(reportId, rejectReason);
        }
    }

    /**
     *
     * @return all reports
     */
    @Override
    public List<Report> findAll() {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            return reportDao.findAll();
        }
    }

    /**
     *
     * @param id report id
     * @return report by id
     */
    @Override
    public Report getById(Long id) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            return reportDao.getById(id);
        }
    }

    /**
     * Creates a new report
     *
     * @param report report
     */
    @Override
    public void create(Report report) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            reportDao.create(report);
        }
    }

    /**
     * Updates the report
     *
     * @param report report
     */
    @Override
    public void update(Report report) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            reportDao.update(report);
        }
    }

    /**
     * Removes the report
     *
     * @param id report id
     */
    @Override
    public void delete(Long id) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao(ConnectionPool.getConnection())) {
            reportDao.delete(id);
        }
    }
}
