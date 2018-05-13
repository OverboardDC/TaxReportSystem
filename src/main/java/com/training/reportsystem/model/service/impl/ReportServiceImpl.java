package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.impl.ReportDaoImpl;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportDao reportDao;

    public ReportServiceImpl() {
        reportDao = new ReportDaoImpl();
    }

    @Override
    public List<Report> findAllByUser(Long userId, Pagination pagination) {
        return reportDao.findAllByUser(userId, pagination);
    }

    @Override
    public List<Report> findAllByInspector(Long inspectorId, Pagination pagination) {
        return reportDao.findAllByInspector(inspectorId, pagination);
    }

    @Override
    public void approveReport(Long reportId) {
        reportDao.approveReport(reportId);
    }

    @Override
    public void rejectReport(Long reportId, String rejectReason) {
        reportDao.rejectReport(reportId, rejectReason);
    }

    @Override
    public List<Report> findAll() {
        return null;
    }

    @Override
    public Report getById(Long id) {
        return reportDao.getById(id);
    }

    @Override
    public void create(Report report) {
        reportDao.create(report);
    }

    @Override
    public void update(Report report) {
        reportDao.update(report);
    }

    @Override
    public void delete(Long id) {

    }
}
