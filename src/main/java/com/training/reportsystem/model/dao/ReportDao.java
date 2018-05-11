package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.Report;

import java.util.List;

public interface ReportDao extends GenericDao<Report> {

    List<Report> findAllByUser(Long userId);

    List<Report> findAllByInspector(Long inspectorId);

    void approveReport(Long reportId);

    void rejectReport(Long reportId, String rejectReason);
}
