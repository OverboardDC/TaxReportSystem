package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.report.Report;

import java.util.List;

public interface ReportService extends GenericService<Report> {

    List<Report> findByUser(Long userId);

}
