package com.training.reportsystem.model.service.impl.hibernate;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.impl.hibernate.ReportDaoHibernate;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/12/2018.
 */
@Service
public class ReportServiceHibernate implements ReportService {

    private ReportDao reportDao;

    @Override
    public Report getById(Long reportId) {
        return reportDao.getById(reportId);
    }

    @Override
    public void create(Report report) {
        reportDao.create(report);
    }

    @Override
    public void update(Report report) {
        reportDao.edit(report);
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
    public void approveReport(Long reportId) {
        reportDao.approveReport(reportId);
    }

    @Override
    public void rejectReport(Long reportId, String rejectReason) {
        reportDao.rejectReport(reportId, rejectReason);
    }

    @Autowired
    public void setReportDao(ReportDao reportDao) {
        this.reportDao = reportDao;
    }
}
