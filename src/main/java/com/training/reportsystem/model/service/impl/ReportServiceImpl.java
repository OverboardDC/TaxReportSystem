package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.impl.ReportDaoImpl;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportDao reportDao;

    public ReportServiceImpl() {
        reportDao = new ReportDaoImpl();
    }

    @Override
    public List<Report> findAllByUser(Long userId) {
        return reportDao.findAllByUser(userId);
    }

    @Override
    public List<Report> findAllByInspector(Long inspectorId) {
        return reportDao.findAllByInspector(inspectorId);
    }

    @Override
    public List<Report> findAll() {
        return null;
    }

    @Override
    public Report getById(Long id) {
        return null;
    }

    @Override
    public void create(Report report) {
        reportDao.create(report);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
