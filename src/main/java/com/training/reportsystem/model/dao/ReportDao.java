package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public interface ReportDao {

    Report getById(Long reportId);

    void create(Report report);

    void edit(Report report);

    List<Report> findAllByUser(Long userId);

    List<Report> findAllByInspector(Long inspectorId);

    void approveReport(Long reportId);

    void rejectReport(Long reportId, String rejectReason);
}
