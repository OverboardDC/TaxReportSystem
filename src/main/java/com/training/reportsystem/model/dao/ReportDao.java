package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.Report;

import java.util.List;

public interface ReportDao extends GenericDao<Report> {

    List<Report> findAllByUser(Long userId);
}
