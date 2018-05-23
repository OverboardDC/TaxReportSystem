package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    @Override
    public List<Report> findAllByUser(Long userId, Pagination pagination) {
        return DaoFactory.getInstance().createReportDao().findAllByUser(userId, pagination);
    }

    @Override
    public List<Report> findAllByInspector(Long inspectorId, Pagination pagination) {
        return DaoFactory.getInstance().createReportDao().findAllByInspector(inspectorId, pagination);
    }

    @Override
    public void approveReport(Long reportId) {
        DaoFactory.getInstance().createReportDao().approveReport(reportId);
    }

    @Override
    public void rejectReport(Long reportId, String rejectReason) {
        DaoFactory.getInstance().createReportDao().rejectReport(reportId, rejectReason);
    }

    @Override
    public List<Report> findAll() {
        return DaoFactory.getInstance().createReportDao().findAll();
    }

    @Override
    public Report getById(Long id) {
        return DaoFactory.getInstance().createReportDao().getById(id);
    }

    @Override
    public void create(Report report) {
        DaoFactory.getInstance().createReportDao().create(report);
    }

    @Override
    public void update(Report report) {
        DaoFactory.getInstance().createReportDao().update(report);
    }

    @Override
    public void delete(Long id) {
        DaoFactory.getInstance().createReportDao().delete(id);
    }
}
