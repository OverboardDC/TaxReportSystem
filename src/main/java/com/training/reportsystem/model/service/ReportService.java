package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public interface ReportService {

    Report getById(Long reportId);

    void create(Report report);

    void update(Report report);

    List<Report> findAllByUser(Long userId);

    List<Report> findAllByInspector(Long inspectorId);

    void approveReport(Long reportId);

    void rejectReport(Long reportId, String rejectReason);

}
