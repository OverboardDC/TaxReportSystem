package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.Report;

import java.util.List;

public interface ReportService extends GenericService<Report> {

    List<Report> findAllByUser(Long userId);

    List<Report> findAllByInspector(Long inspectorId);

}
