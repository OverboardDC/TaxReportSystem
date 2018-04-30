package com.training.reportsystem.service;

import com.training.reportsystem.entity.report.Report;

import java.util.List;

public interface ReportService extends GenericService<Report> {

    List<Report> findByUser(Long userId);

}
