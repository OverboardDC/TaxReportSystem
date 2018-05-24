package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.factory.DaoFactory;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    @Override
    public List<Report> findAllByUser(Long userId, Pagination pagination) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            return reportDao.findAllByUser(userId, pagination);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Report> findAllByInspector(Long inspectorId, Pagination pagination) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            return reportDao.findAllByInspector(inspectorId, pagination);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void approveReport(Long reportId) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            reportDao.approveReport(reportId);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void rejectReport(Long reportId, String rejectReason) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            reportDao.rejectReport(reportId, rejectReason);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Report> findAll() {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            return reportDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Report getById(Long id) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            return reportDao.getById(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void create(Report report) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            reportDao.create(report);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Report report) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            reportDao.update(report);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Long id) {
        try (ReportDao reportDao = DaoFactory.getInstance().createReportDao()) {
            reportDao.delete(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
