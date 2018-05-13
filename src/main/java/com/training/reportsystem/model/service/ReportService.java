package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.util.Pagination;

import java.util.List;

public interface ReportService extends GenericService<Report> {

    List<Report> findAllByUser(Long userId, Pagination pagination);

    List<Report> findAllByInspector(Long inspectorId, Pagination pagination);

    void approveReport(Long reportId);

    void rejectReport(Long reportId, String rejectReason);

}
